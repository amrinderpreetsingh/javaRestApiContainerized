# Use a Gradle image to build the project
FROM gradle:7.5.1-jdk17 AS build
WORKDIR /app

# Copy the project files to the Docker container
COPY . .

# Build the project
RUN gradle build -x test

# Use a smaller JRE image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/javaRestApiContianerized-1.0-SNAPSHOT.jar /app/javaRestApiContianerized-1.0-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "/app/javaRestApiContianerized-1.0-SNAPSHOT.jar"]
