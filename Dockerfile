FROM openjdk:8-jdk-alpine AS build
COPY --from=build build/libs/rest-service-0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]