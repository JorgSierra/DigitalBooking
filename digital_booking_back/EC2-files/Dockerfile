# Image to execute java
FROM  openjdk:17-alpine
# Copy executable from instance to docker image
COPY back_package.jar app.jar
# Defines command to execute app
ENTRYPOINT ["java","-jar","/app.jar"]
