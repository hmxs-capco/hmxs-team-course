FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8090

ARG JAR_FILE=build/libs/rest-service-0.1.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]