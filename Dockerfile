FROM openjdk:17-jdk-alpine
LABEL authors="mateusz-ochab"
RUN addgroup -S app && adduser -S app -G app
USER app

COPY ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]