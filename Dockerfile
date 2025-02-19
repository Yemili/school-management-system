# Use Amazon Corretto base image for Java 17 (or higher if required)
FROM amazoncorretto:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled jar file from your local machine to the container
COPY target/student-0.0.1-SNAPSHOT.jar /app/student-0.0.1-SNAPSHOT.jar

# Expose the port your application will run on
EXPOSE 8081

# Run the application using the Java command
CMD ["java", "-jar", "student-0.0.1-SNAPSHOT.jar"]