FROM openjdk:8-jdk-alpine
COPY rest-service-0.1.jar rest-service-0.1.jar
CMD ["java","-jar","rest-service-0.1.jar"]