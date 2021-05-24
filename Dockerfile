FROM openjdk:12-jdk-alpine
COPY build/libs/rest-service-0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]