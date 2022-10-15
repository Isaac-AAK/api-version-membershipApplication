FROM openjdk:17
EXPOSE 8080
COPY target/api-test.jar api-test.jar
ENTRYPOINT ["java", "-jar", "/api-test.jar"]