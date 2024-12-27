# Use a base image with Java 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host machine to the container's /app directory
# It's good to specify the JAR file name explicitly for clarity
COPY target/backend.jar /app/backend.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/backend.jar"]
