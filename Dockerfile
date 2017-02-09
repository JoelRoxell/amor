FROM openjdk:8-jdk
RUN apt-get update
RUN apt-get install -y maven

ARG VERSION

WORKDIR /usr/src/amor/

COPY pom.xml .

COPY src ./src/

# Create jar
RUN ["mvn", "package"]

RUN update-java-alternatives --set java-1.8.0-openjdk-amd64
RUN java -version

RUN mv "./target/amor-${VERSION}-jar-with-dependencies.jar" "./target/amor.jar"

EXPOSE 8000

ENTRYPOINT ["java","-jar", "./target/amor.jar"]
