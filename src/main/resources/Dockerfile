#
#desplegar en dcos
#docker rmi camiloriguer/analytics-comfandi-jvm
#docker build -f src/main/resources/Dockerfile -t camiloriguer/analytics-comfandi-jvm .
#docker push camiloriguer/analytics-comfandi-jvm:latest
#scalar a 0 y luego a 1 el servicio backend-analytics


FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/analitica-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]