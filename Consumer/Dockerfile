FROM maven:4.0.0 AS builder
WORKDIR /Consumer/
COPY . .
RUN mvn clean package


FROM openjdk:11.0.1-jdk-buster
COPY --from=builder /Consumer/target/consumerrabbitmq-0.0.1-SNAPSHOT /Consumer/Consumer-1.0.jar
WORKDIR /Consumer/
ENTRYPOINT ["java",  "-jar","Consumer-1.0.jar"]

