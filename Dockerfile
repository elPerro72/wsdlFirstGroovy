FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/wsdlFirstGroovy-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8095 9090

# Build an image from a Dockerfile. It takes an optional tag name with -t
# docker build -t "tag:tag" .
#
# Useful docker commands:
#
# docker images --> You can use the docker images command to see a list of all images on your system.
# docker ps --> List container
# docker ps --> The docker ps command shows you all containers that are currently running.
#
# Run a Docker container based on this image (or imageId)
# docker run -d -p 8095:8095 -p 9090:9090 a344e222a5fe
