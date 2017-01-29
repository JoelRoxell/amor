FROM java:8

EXPOSE 4567

ADD /target/amor-1.0.0-jar-with-dependencies.jar amor.jar

ENTRYPOINT ["java","-jar","amor.jar"]
