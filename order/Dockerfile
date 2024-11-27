# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build file and source code
COPY target/*.jar app.jar

ENV EUREKA_SERVER_URL=http://localhost:8761/eureka/
ENV ZIPKIN_URL=http://localhost:9411/api/v2/spans
ENV LOGSTASH_HOST=34.66.120.25
ENV LOGSTASH_PORT=5000

# Expose the application's port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
