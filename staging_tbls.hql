use retail_stg;

drop table if exists custdetstg;

create table custdetstg(customernumber STRING, customername STRING, contactfullname string, address struct<addressLine1:string,city:string,state:string,postalCode:bigint,counrtry:string,phone:bigint>, creditlimit float,checknum string,checkamt int,paymentdate date)
row format delimited
fields terminated by '~'
collection items terminated by '$'
stored as textfile;

load data inpath '/user/hduser/pigout/custdetcomplextypes' overwrite into table custdetstg;

drop table if exists orddetstg;

create table orddetstg(customernumber STRING, ordernumber STRING, shippeddate date,status string, comments string,productcode string,quantityordered int,priceeach decimal(10,2),orderlinenumber int,productName STRING,productLine STRING,
productScale STRING,productVendor STRING,productDescription STRING,quantityInStock int,buyPrice decimal(10,2),MSRP decimal(10,2),orderdate date)
row format delimited
fields terminated by '~'
stored as textfile;

load data inpath '/user/hduser/pigout/orddetails/' overwrite into table orddetstg;
