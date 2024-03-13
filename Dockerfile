FROM openjdk:17-jdk
COPY build/libs/maeilmail-0.0.1-SNAPSHOT.jar maeilmail.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/maeilmail.jar"]