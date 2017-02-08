FROM ubuntu:16.04

RUN apt-get update

RUN apt-get install software-properties-common -y
RUN add-apt-repository ppa:webupd8team/java -y

RUN apt-get update

RUN echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections
RUN apt install oracle-java8-installer -y
RUN apt-get install -y maven

WORKDIR /usr/src/amor/

COPY . /usr/src/amor/
# Prepare by downloading dependencies
ADD pom.xml /usr/src/amor/pom.xml

ADD ./target/amor-0.1.0-jar-with-dependencies.jar /usr/src/amor/target/amor.jar

RUN ["mvn", "package"]

EXPOSE 8000

RUN  ls -l /usr/src/amor

RUN java -version

ENTRYPOINT ["java","-jar","target/amor.jar"]