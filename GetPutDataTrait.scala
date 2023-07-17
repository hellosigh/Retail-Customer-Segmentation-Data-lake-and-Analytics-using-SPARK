package org.inceptez.retail
import org.apache.spark.sql.SparkSession._
import org.apache.spark.sql._
import java.util.Properties
import java.io.FileInputStream
trait GetPutDataTrait {
  def getRdbmsData(sqlc: org.apache.spark.sql.SQLContext,DatabaseName: String, TableName: String, PartitionColumn:String, 
      ConnFile: String,upperbound:Long,partflag:Boolean): DataFrame= {

val conn=new Properties()
val propFile= new FileInputStream(s"$ConnFile") 
conn.load(propFile)

/* Reading mysql server connection detail from property file */
val Driver=conn.getProperty("driver") 
val Host =conn.getProperty("host") 
val Port =conn.getProperty("port") 
val User =conn.getProperty("user") 
val Pass =conn.getProperty("pass")
val DbType=conn.getProperty("dbtype")
val url=DbType+Host+":"+Port+"/"+s"$DatabaseName"
println(url)
if(partflag==true)
{
val customboundquery=s"(select min($PartitionColumn) as lowerval,max($PartitionColumn) as upperval from $TableName ) tblquery"
val dfboundary= sqlc.read.format("jdbc")
.option("driver",s"$Driver")
.option("url",s"$url")
.option("user",s"$User")
.option("password",s"$Pass")
.option("dbtable",customboundquery).load()
println("Boundary query completed"+dfboundary.count())
import sqlc.implicits._
val (lowerbound,upperbound)=dfboundary.as[(String,String)].first  
if (lowerbound == null || upperbound ==  null)
{
println(" *** Attention *** - No source data found, please ensure to run the sql - update empoffice.employees set upddt=current_date;")
throw new Exception()  
}

val numpart=(upperbound.toLong/100)+1

println((lowerbound, upperbound,numpart) + s"Lower, upper boundary and number of partitions for the table $TableName " )

sqlc.read.format("jdbc")
.option("driver",s"$Driver")
.option("url",s"$url")
.option("user",s"$User")
.option("lowerBound",lowerbound)
.option("upperBound",upperbound)
.option("numPartitions",numpart)
.option("partitionColumn",s"$PartitionColumn")
.option("password",s"$Pass")
.option("dbtable",s"$TableName").load()
}
else
{
sqlc.read.format("jdbc")
.option("driver",s"$Driver")
.option("url",s"$url")
.option("user",s"$User")
.option("password",s"$Pass")
.option("dbtable",s"$TableName").load()
  }  
}
  

}