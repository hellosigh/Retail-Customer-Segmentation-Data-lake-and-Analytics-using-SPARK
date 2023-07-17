# Retail-Customer-Segmentation-Data-lake-and-Analytics-using-SPARK
This Data lake project provides an all in one central repository for converged Data Platform that helps retailers  chain of stores to integrate and analyze a wide variety of online and offline customer data including the customer  data, products, purchases, orders, employees and comments data.. Retailers can analyze this data to generate 
insights about individual consumer behaviors and preferences, Recommendations and Loyalty Programs. This tool 
builds the strategies, Key Performance Indicators (KPI) definitions and implementation roadmaps that assists our 
esteemed clients in their Analytics & Information ecosystem journey right from Strategy definition to large scale 
Global Implementations & Support using the Bigdata ecosystems.

# how to work on this project

# Login to VMWare –

# Start the Following Eco systems
  Start Hadoop:
  start-all.sh
  mr-jobhistory-daemon.sh start historyserver

  # Start HIVE:
    Start Hive metastore in a terminal: 
    hive --service metastor
 # Start hive cli in another terminal: 
    hive
  # Start MYSQL -  
  Login to mysql using root user:
    sudo service mysqld start
     mysql -u root -p 
    password: Root123$
     mysql
# Run the below sqls to create and load data in the tables created in the below
 schemasordersproduct_ORIG.sql - Schema: ordersproducts, Tables: orders, products, 
 orderdetailscustpayments_ORIG.sql - Schema: custpayments, Tables: custpayments and 
  paymentspaymentsempoffice.sql - Schema: empoffice, Tables: employees and offices
 # do the Spark Code Setup
 # Install Cassandra:
 Start Cassandra
 cd /usr/local/cassandra/bin
  ./cqlsh
  # Create Key Space
  # Go ahead and execute the DataLake.scala in the Eclipse and check the data is loaded into all hive tables, 
      filesystem and upto Cassandra table
     
