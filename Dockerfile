FROM openjdk:11
ADD target/weather-app-0.0.1-SNAPSHOT.jar weather-app-0.0.1-SNAPSHOT.jar
EXPOSE 8345
ENTRYPOINT ["java","-jar","weather-app.jar"]

