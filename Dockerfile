FROM openjdk:9

ARG version

RUN apt-get update
RUN apt-get install -y maven

WORKDIR /usr/src/amor/

# Prepare by downloading dependencies
ADD pom.xml /usr/src/amor/pom.xml

ADD . /usr/src/amor/
RUN ["mvn", "package"]

EXPOSE 8000

ENTRYPOINT ["java","-jar","target/amor-0.1.0-jar-with-dependencies.jar"]