# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build file and source code
COPY target/cart-0.0.1-SNAPSHOT.jar app.jar

# 设置多个默认环境变量
ENV EUREKA_SERVER_URL=http://localhost:8761/eureka/
ENV ZIPKIN_URL=http://localhost:9411/api/v2/spans
ENV LOGSTASH_HOST=34.66.120.25
ENV LOGSTASH_PORT=5000

# Expose the application's port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]