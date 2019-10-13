#! /bin/sh
echo "creating mysql image"

docker build -t butola-msyql .

if [ $? == 0 ]
then
   echo "a is equal to b"
fi

if [ $? == 0 ]
then
    echo "start mysql container"
    docker run -p 3306:3306 --name stormchaser butola-msyql
fi

sleep 15

echo "run liquibase scripts to load data into the database"
mvnw liquibase:update

