FROM openjdk:8-jdk-alpine
ADD target/ms-account-0.0.1-SNAPSHOT.jar account.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account.jar"]