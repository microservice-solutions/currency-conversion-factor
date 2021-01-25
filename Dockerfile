FROM openjdk:8-jdk-alpine
RUN addgroup -S currencyconvertionfactor && adduser -S currencyconvertionfactor -G currencyconvertionfactor
USER currencyconvertionfactor:currencyconvertionfactor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]