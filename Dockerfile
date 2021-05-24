FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8090

COPY build/libs/rest-service-0.1.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]