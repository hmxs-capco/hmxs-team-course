FROM openjdk:8-jdk-alpine
COPY hmxs-team-course-0.1.jar hmxs-team-course-0.1.jar
CMD ["java","-jar","hmxs-team-course-0.1.jar"]