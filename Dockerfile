FROM openjdk:8-jdk-alpine
COPY rest-service-0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]