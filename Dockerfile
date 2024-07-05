# syntax=docker/dockerfile:1.4

FROM eclipse-temurin:17-jdk AS builder
WORKDIR /opt/workspace
USER root:root
COPY . .

RUN apt-get update
RUN apt-get install -y python3 python3-pip
RUN ./mvnw dependency:go-offline
RUN ./mvnw install -D skipTests

FROM builder AS development
RUN pip install -r script/requirements.txt
CMD ./mvnw spring-boot:run

FROM builder AS production
RUN mkdir -p target/dependency
WORKDIR /opt/workspace/target/dependency
RUN jar -xf ../*.jar

FROM spark:3.5.1-java17-python3
WORKDIR /opt/spark/work-dir
ARG DEPENDENCY=/opt/workspace/target/dependency
COPY --from=production ${DEPENDENCY}/BOOT-INF/lib jpx/lib
COPY --from=production ${DEPENDENCY}/META-INF jpx/META-INF
COPY --from=production ${DEPENDENCY}/BOOT-INF/classes jpx
COPY --from=production /opt/workspace/script script
RUN pip install -r script/requirements.txt
ENTRYPOINT ["java", "-cp", "jpx:jpx/lib/*", "com.pandora.jpx.JpxApplication"]
