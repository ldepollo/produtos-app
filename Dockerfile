FROM openjdk:17

COPY ./target/produtos-app-0.0.1-SNAPSHOT.jar produtos-app-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","produtos-app-0.0.1-SNAPSHOT.jar"]