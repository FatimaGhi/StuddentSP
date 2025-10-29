FROM  openjdk:17-jdk-alpine
WORKDIR /app
COPY  target/student-0.0.1-SNAPSHOT.jar student.jar
EXPOSE 8090
ENTRYPOINT ["java" ,"-jar","student.jar"]
