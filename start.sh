#!/bin/sh
echo "Starting servers please wait"
./stop-server.sh
mvn -f app-config spring-boot:run &
mvn -f appinit-files spring-boot:run &
#mvn -f appinit-page-events spring-boot:run &
mvn -f appinit-pages spring-boot:run &
mvn -f data-models spring-boot:run &
#mvn -f appinit-widgets spring-boot:run &
