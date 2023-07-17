package org.inceptez.retail
import org.apache.spark.sql._;
import java.util.Properties
import java.io.FileInputStream
//import java.sql.Connection
import scala.reflect.runtime.universe

object DataLake extends GetPutDataTrait with WriteDataTrait{

def main( args: Array[String]) {
val spark=SparkSession.builder().appName("Spark Datalake Project").master("local[*]")
.config("spark.history.fs.logDirectory", "file:///tmp/spark-events")
.config("spark.eventLog.dir", "file:///tmp/spark-events")
.config("spark.eventLog.enabled", "true")
.config("hive.metastore.uris","thrift://localhost:9083")
.config("spark.sql.warehouse.dir","hdfs://localhost:54310/user/hive/warehouse")
.config("spark.sql.warehouse.dir","hdfs://localhost:54310/user/hive/warehouse")
.config("spark.sql.shuffle.partitions",10)
.config("spark.sql.crossJoin.enabled",true)
.enableHiveSupport()
.getOrCreate();

val sc =spark.sparkContext //Renaming SparkContext
val sqlc=spark.sqlContext //Renaming SqlContext
sc.setLogLevel("error")
import sqlc.implicits._

val confile="/home/hduser/retailordersspark/connection.prop"

val conn=new Properties()
val propFile= new FileInputStream(confile) 
conn.load(propFile)

/* Reading hdfs hostinfo from property file */
val hdfsuri=conn.getProperty("hdfsuri") 

//calling method to pull employees table data from mysql/any db under empoffice schema
//Format: methodname(<sqlcontext object>,<schemaname>,<TableName>,<connection information>)
//var upperbound=10000; //expectation of max number of rows expecting in this employee base table
//Run the below query to update the data to recent date
//update empoffice.employees set upddt=current_date;

val dummyupperbound=1;

//println(upperbound)

val customquery="(select * from employees where upddt>current_date-interval 1 day) tblquery"
println("calling the getRdbmsData")
val dfemployees= getRdbmsData(sqlc,"empoffice",customquery,"employeeNumber",confile,s"$dummyupperbound".toLong,true) 
dfemployees.createOrReplaceTempView("employee") //registering as temporary table
println("Employee data successfully pulled from Mysql!!!" )
dfemployees.show(2)

val dfoffices= getRdbmsData(sqlc,"empoffice","offices","",s"$confile",s"$dummyupperbound".toLong,false) 
dfoffices.createOrReplaceTempView("offices") //registering as temporary table

import sqlc.implicits._
import org.apache.spark.sql.functions._
spark.sql("create database if not exists retailstg")
spark.sql("use retailstg")
val loadempflag=writeHiveTable(dfemployees,"retailstg.employees",false,"")
val loadofficeflag=writeHiveTable(dfoffices,"retailstg.offices",false,"")
if(loadempflag==true && loadofficeflag==true)
{
println("Employee data successfully loaded into Hive Table "+ "retailstg.employees " + "retailstg.offices"  )  
}

val custpaymentsquery="""(select c.customerNumber customernumber, upper(c.customerName) as custname,c.contactFirstName,c.contactLastName,
c.phone,c.addressLine1,c.city,c.state,c.postalCode,c.country ,c.salesRepEmployeeNumber,c.creditLimit ,
p.checknumber,p.paymentdate,p.amount  
from customers c inner join payments p 
on c.customernumber=p.customernumber 
and year(p.paymentdate)=2020 
and month(p.paymentdate)=10) query """

val dfcustpayments= getRdbmsData(sqlc,"custpayments",custpaymentsquery,"customernumber",s"$confile",dummyupperbound.toLong,true) 
dfcustpayments.createOrReplaceTempView("custpayments") //registering as temporary table
println("custpayments data successfully pulled from Mysql!!!" )
dfcustpayments.show(2)

val orderprodquery="""(select o.customernumber,o.ordernumber,o.orderdate,o.shippeddate,o.status,o.comments,
  od.quantityordered,od.priceeach,od.orderlinenumber,p.productCode,p.productName,
  p.productLine,p.productScale,p.productVendor,p.productDescription,p.quantityInStock,p.buyPrice,p.MSRP  
  from orders o inner join orderdetails od 
  on o.ordernumber=od.ordernumber  
  inner join products p 
  on od.productCode=p.productCode 
  and year(o.orderdate)=2020 
  and month(o.orderdate)=10 ) ordprod"""

val dforderprod= getRdbmsData(sqlc,"ordersproducts",orderprodquery,"customernumber",s"$confile",dummyupperbound.toLong,true) 
dforderprod.createOrReplaceTempView("orddetstg") //registering as temporary table
println("custpayments data successfully pulled from Mysql!!!" )
dforderprod.show(2)

/*Under staging retailstg Database create temporary managed tables, Load the DB imported data into the 
 * below managed table that will be dropped and recreated on daily basis so data will be cleaned when dropped, 
 * if we use external table we have to manage the data cleanup separately as given below using the 
 * truncate statement.  */
spark.sql("create database if not exists retailstg");

val loadcustpaymentsflag=writeHiveTable(dfcustpayments,"retailstg.custdetails_raw",false,"")
val loadorderprodflag=writeHiveTable(dforderprod,"retailstg.orddetstg",false,"")

if(loadcustpaymentsflag==true && loadorderprodflag==true)
{
println("customer payment and order product data successfully loaded into Hive Table "+ "retailstg.custdetails_raw " + "retailstg.orddetstg"  )  
println(spark.sql("select 1 from retailstg.custdetails_raw").count());
println(spark.read.table("retailstg.orddetstg").count());
}

/*External tables with partition/bucketing usecases : Under retail_curated database create and 
 * load external tables which is partitioned for applying where clauses and bucketed to join with 
 * the other external tables more efficiently. Why we are creating as external table because we may 
 * keep on adding more data in this table or performing more iterative queries without dropping it 
 * as we have to join these tables to produce the final mart.*/ 

spark.sql("drop database if exists retail_curated cascade");
spark.sql("create database retail_curated");

spark.sql("""create table retail_curated.custdetstgcured(customernumber STRING, customername STRING, 
  contactfullname string, address struct<addressLine1:string,city:string,state:string,postalCode:bigint,
  country:string,phone:bigint>, creditlimit float,checknum string,checkamt float,paymentdate date) 
row format delimited fields terminated by '~' 
stored as textfile""");

spark.sql("""insert overwrite table retail_curated.custdetstgcured select coalesce(customernumber,0),contactfirstname, 
  concat(contactfirstname, ' ', contactlastname) , named_struct('addressLine1', addressLine1, 
  'city', city, 'state', state, 'postalCode', postalCode, 'country', country, 'phone',phone), 
  round(creditlimit), 
  CONCAT(REGEXP_EXTRACT( checknumber ,'[A-Z]+', 0), '-',REGEXP_EXTRACT( checknumber ,'[0-9]+', 0)),
  round(amount),coalesce(paymentdate,current_date) 
  from retailstg.custdetails_raw where creditlimit>=amount""")
  println(spark.read.table("retail_curated.custdetstgcured").count)
 
  //spark.sqlContext.setConf("hive.enforce.bucketing","true");
  spark.sqlContext.setConf("hive.exec.dynamic.partition","true"); 
  spark.sqlContext.setConf("hive.exec.dynamic.partition.mode","nonstrict");
  spark.sql("""create external table retail_curated.custdetpartbuckext	 
(customernumber STRING, customername STRING, contactfullname string, address struct<addressLine1:string,city:string,state:string,postalCode:bigint,country:string,phone:bigint>,creditlimit float,checknum string,checkamt int) 
partitioned by (paymentdate date) 
row format delimited fields terminated by '~' collection items terminated by '$' 
stored as textfile location 'hdfs:///user/hduser/custorders/custdetpartbuckext'""");
  
  spark.sql("""insert into table retail_curated.custdetpartbuckext partition(paymentdate) 
select customernumber,customername, contactfullname, address ,creditlimit,checknum,checkamt,paymentdate 
from retail_curated.custdetstgcured """)

spark.sql("""create external table retail_curated.orddetpartbuckext(customernumber STRING, ordernumber STRING, shippeddate 
date,status string, comments string,productcode string,quantityordered int,priceeach decimal(10,2),orderlinenumber int,productName STRING,productLine STRING, productScale STRING,productVendor STRING,productDescription STRING,quantityInStock int,buyPrice decimal(10,2),MSRP decimal(10,2)) partitioned by (orderdate date) 
row format delimited fields terminated by '~' collection items terminated by '$' 
stored as textfile location 'hdfs:///user/hduser/custorders/orddetpartbuckext'""")

spark.sql("""insert into table retail_curated.orddetpartbuckext partition(orderdate) select customernumber,ordernumber, shippeddate,status,comments,productcode,quantityordered ,priceeach ,orderlinenumber ,productName 
,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP,orderdate 
from retailstg.orddetstg""")

spark.sql("""create database if not exists retail_discovery""");
  
spark.sql("""create external table if not exists retail_discovery.dim_order_rate (rid int,orddesc varchar(200),comp_cust varchar(10),siverity int, intent varchar(100)) 
row format delimited fields terminated by ','
location 'hdfs:///user/hduser/retailordersspark/dimorders/'""")

spark.sql("""load data local inpath '/home/hduser/retailordersspark/data/orders_rate.csv' overwrite into table retail_discovery.dim_order_rate""")


spark.sql("""drop table if exists cust_navigation""")

spark.sql("""create table  retailstg.cust_navigation (customernumber string,comments string,pagenavigation array 
<string>,pagenavigationidx array <int>) 
row format delimited fields terminated by ','
collection items terminated by  '$'""")

spark.sql("""load data local inpath '/home/hduser/retailordersspark/data/cust_visits.csv' overwrite into table retailstg. cust_navigation""")

spark.sql("""create external table if not exists retail_discovery.cust_navigation (customernumber string,navigation_index int,navigation_pg string) 
row format delimited fields terminated by ',' 
location 'hdfs:///user/hduser/custnavigation/'""")

spark.sql("""insert into table retail_discovery.cust_navigation 
select customernumber,pgnavigationidx,pgnavigation 
from retailstg.cust_navigation
lateral view posexplode(pagenavigation) exploded_data1 as pgnavigationidx,pgnavigation""")

println("What is the First and last page visited and the count of visits.");
val report1=spark.sql("""select c1.navigation_pg,count(distinct c1.customernumber) custcnt,'last pagevisited' pagevisit 
from retail_discovery.cust_navigation  c1 inner join (select a.customernumber,max(a.navigation_index) as maxnavigation from retail_discovery.cust_navigation a group by a.customernumber) as c2 on (c1.customernumber=c2.customernumber and c1.navigation_index=c2.maxnavigation) group by c1.navigation_pg
union all
select navigation_pg,count(distinct customernumber) custcnt,'first pagevisited' pagevisit
from retail_discovery.cust_navigation
where navigation_index=0
group by navigation_pg""");
writeFile(report1.coalesce(1),"json",s"${hdfsuri}/user/hduser/retail_discovery/first_last_page",false,"");

println("What is the most visited page")
val mostvisit=spark.sql("""select navigation_pg,count(customernumber) as cnt
from retail_discovery.cust_navigation
group by navigation_pg
order by cnt desc
limit 1""")

writeFile(mostvisit.coalesce(1),"json",s"${hdfsuri}/user/hduser/retail_discovery/mostvisited",false,"");

spark.sql("""create external table if not exists retail_discovery.cust_frustration_level 
  (customernumber string,total_siverity int,frustration_level string) 
  row format delimited fields terminated by ',' location 'hdfs:///user/hduser/custmartfrustration/'""")
//spark.sql("""set spark.sql.crossJoin.enabled=true""")
  val frustrateddf=spark.sql(""" select customernumber,
  total_siverity,case when total_siverity between -10 and -3 then 'highly frustrated' when total_siverity 
  between -2 and -1 then 'low frustrated' when total_siverity = 0 then 'neutral' 
  when total_siverity between 1 and 2 then 'happy' when total_siverity between 3 and 10 
  then 'overwhelming' else 'unknown' end as customer_frustration_level from 
  ( select customernumber,sum(siverity) as total_siverity from 
  ( select o.customernumber,o.comments,r.orddesc,siverity 
  from retailstg.cust_navigation o left outer join retail_discovery.dim_order_rate r  
  where o.comments like concat('%',r.orddesc,'%')) temp1 
group by customernumber) temp2""")
frustrateddf.show(2,false)
frustrateddf.createOrReplaceTempView("frustrationview")

spark.sql("""insert overwrite table retail_discovery.cust_frustration_level select * from frustrationview""")
println("data writtened to cust_frustration_level")

writeRdbmsData(frustrateddf,"customer_frustration_level","custdb",s"$confile","overwrite")
println("data writtened to final DB Table")
/*
 cd /usr/local/cassandra/bin
 ./cqlsh
create keyspace retail WITH replication = {'class':'SimpleStrategy','replication_factor':1};
use retail;
create table customer_frustration_level
(customernumber text primary key,
total_siverity varint,
customer_frustration_level text);

*/
writeToCassandra(frustrateddf,"customer_frustration_level","retail")

}}