FROM openjdk:11
ADD target/weather-app.jar-0.0.1-SNAPSHOT weather-app.jar-0.0.1-SNAPSHOT
EXPOSE 8345
ENTRYPOINT ["java","-jar","weather-app.jar"]

