FROM maven:4.0.0 AS builder
WORKDIR /Producer/
COPY . .
RUN mvn clean package


FROM openjdk:11.0.1-jdk-buster
COPY --from=builder /Producer/target/producerrabbitmq-0.0.1-SNAPSHOT /Producer/Producer-1.0.jar
WORKDIR /Producer/
ENTRYPOINT ["java",  "-jar","Producer-1.0.jar"]

