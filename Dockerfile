FROM amazoncorretto:21.0.2-alpine3.19
LABEL authors="yeldan"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]