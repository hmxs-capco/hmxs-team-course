FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/rest-service-0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]