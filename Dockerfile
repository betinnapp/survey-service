FROM maven:3.6-jdk-11 as builder

# Copy source files
COPY . /usr/src/survey-service

# Go to source files root
WORKDIR /usr/src/survey-service

# Run build
RUN mvn clean install

# Copy Build Artifacts
COPY --from=builder /usr/src/survey-service/target/survey-service-0.0.1-SNAPSHOT.jar survey-service.jar

# Cofigure environment
ENV SERVER_PORT 8080
ENV JAVA_OPTS "-Xms512m -Xmx512m -server"

# Expose ports
EXPOSE 8080

# Run inside JRE-11 slim container
FROM openjdk:11-jre-slim-sid

# Run built JAR
ENTRYPOINT /usr/bin/java ${JAVA_OPTS} "-Dserver.port=${SERVER_PORT}" -jar "survey-service.jar"