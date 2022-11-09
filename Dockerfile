FROM openjdk:11
COPY target/weather-app.jar weather-app.jar
EXPOSE 8345
ENTRYPOINT ["java","-jar","/weather-app.jar"]

