FROM openjdk:8-jdk-alpine
MAINTAINER yogender@gmail.com

VOLUME /tmp
COPY target/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]