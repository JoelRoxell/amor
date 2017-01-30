FROM java:8

RUN apt-get update
RUN apt-get install -y maven

WORKDIR /usr/src/amor/

# Prepare by downloading dependencies
ADD pom.xml /usr/src/amor/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

ADD src /amor/src
RUN ["mvn", "package"]

EXPOSE 4567
ENTRYPOINT ["java","-jar","amor.jar"]
