echo -e "hduser" | sudo -S rm -rf /usr/local/cassandra
cd /home/hduser/retailordersspark/
tar xvzf apache-cassandra-2.1.22-bin.tar.gz
echo -e "hduser" | sudo -S mv apache-cassandra-2.1.22 /usr/local/cassandra	
cd /usr/local/cassandra/bin
ps -ef | grep cassandra

cpid=`jps | grep Cassandra | awk -F' ' '{print $1}'`
kill -9 $cpid


echo "starting cassandra"
./cassandra

if [ `ps -ef | grep cassandra | wc -l` -eq 2 ]
then
echo "Cassandra Started Successfully"
fi
