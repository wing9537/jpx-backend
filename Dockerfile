FROM openjdk:17-ea-10-jdk-oracle
ENV DB_HOST=127.0.0.1 DB_USERNAME=admin DB_PASSWORD=password
COPY /target/jpx-*.jar jpx.jar
ENTRYPOINT ["java","-jar","/jpx.jar"]