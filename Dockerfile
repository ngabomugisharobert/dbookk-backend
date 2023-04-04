FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080

CMD [ "mvn", "install" ]
ARG JAR_FILE=target/dbookk-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]