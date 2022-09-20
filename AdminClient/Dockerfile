FROM maven:4.0.0 AS builder
WORKDIR /AdminClient/
COPY . .
RUN mvn clean package


FROM openjdk:11.0.1-jdk-buster
COPY --from=builder /AdminClient/target/AdminClient-0.0.1-SNAPSHOT /AdminClient/AdminClient-1.0.jar
WORKDIR /AdminClient/
ENTRYPOINT ["java",  "-jar","AdminClient-1.0.jar"]

