#!/bin/sh

while ! nc -z db 3306 ; do
    echo "Waiting for mysql database to come up"
    sleep 2
done
java -jar /app.jar