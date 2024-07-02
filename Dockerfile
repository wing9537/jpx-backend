# FROM spark:3.5.1-java17-python3 AS development
FROM eclipse-temurin:17-jdk AS development
WORKDIR /opt/spark/work-dir
USER root:root
COPY . .

ENV DB_HOST=jpx-database
ENV DB_USERNAME=admin
ENV DB_PASSWORD=admin
ENV PYTHON_HOME=python3

RUN apt-get update
RUN apt-get install -y python3 python3-pip
RUN pip install -r script/requirements.txt
CMD ./mvnw spring-boot:run

FROM development AS build
CMD mvn clean package -D skipTests

#COPY /target/jpx-*.jar jpx.jar
#ENTRYPOINT ["java","-jar","/jpx.jar"]
