FROM openjdk:11-jre-slim
EXPOSE 8083
VOLUME /tmp
COPY . .
ENTRYPOINT ["java","-jar","target/survey-service-0.0.1-SNAPSHOT.jar"]