FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/SubjectService-0.0.1-SNAPSHOT.jar /app/hello.jar

EXPOSE 8085

CMD ["java", "-jar", "hello.jar"]