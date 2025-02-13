FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY ./pom.xml /app
COPY ./src /app/src
COPY ./src/main/resources/db/migration src/main/resources/db/migration
RUN mvn clean package -Dmaven.test.skip=true


FROM openjdk:17-jdk-alpine
WORKDIR /app


COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
