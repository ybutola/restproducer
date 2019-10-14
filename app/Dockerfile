FROM openjdk:8-jdk-alpine
MAINTAINER yogender@gmail.com

VOLUME /tmp
COPY target/*-SNAPSHOT.jar app.jar
COPY waitfordb.sh /opt/spring-cloud/bin/

RUN chmod 755 /opt/spring-cloud/bin/waitfordb.sh
#ENTRYPOINT ["java", "-jar", "app.jar"]