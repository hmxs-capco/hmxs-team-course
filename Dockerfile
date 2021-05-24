FROM openjdk:8-jdk-alpine as ref
VOLUME /tmp
EXPOSE 8090

ARG JAR_FILE
COPY --from=ref /build/libs/rest-service-0.1.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]