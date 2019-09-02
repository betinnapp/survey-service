FROM openjdk:11-jre


ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/service.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/service/service.jar