# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build file and source code
COPY target/*.jar app.jar

#ENV EUREKA_SERVER_URL=http://localhost:8761/eureka/
#ENV ZIPKIN_URL=http://34.70.120.97:9411/api/v2/spans

# Expose the application's port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
