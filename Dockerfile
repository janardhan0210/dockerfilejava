# Use a base image with Java installed
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /home/janardhan/Docker/dockerfilejava

# Copy the compiled Java application JAR file into the container
COPY target/dockerfilejava.jar* /home/janardhan/Docker/dockerfilejava/dockerfilejava.jar

# Expose the port your Java application listens on
EXPOSE 8500

# Command to run your Java application when the container starts
CMD ["java", "-jar", "/home/janardhan/Docker/dockerfilejava/dockerfilejava.jar"]
