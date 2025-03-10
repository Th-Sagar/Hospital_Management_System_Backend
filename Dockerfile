# Use an official Java 21 runtime as a base image
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the application JAR file from the target directory
COPY target/*.jar app.jar

# Expose port 9090
EXPOSE 9090

# Run the application
CMD ["java", "-jar", "app.jar"]
