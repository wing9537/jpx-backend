FROM openjdk:17-ea-10-jdk-oracle
MAINTAINER tommykwok
COPY /target/jpx-0.0.1-SNAPSHOT.jar jpx.jar
ENTRYPOINT ["java","-jar","/jpx.jar"]