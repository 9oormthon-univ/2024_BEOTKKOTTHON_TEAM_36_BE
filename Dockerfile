FROM openjdk:17-jdk
COPY build/libs/emailer-0.0.1-SNAPSHOT.jar emailer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/emailer.jar"]