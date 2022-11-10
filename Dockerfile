FROM openjdk:11-jre-slim-buster
ADD target/utmtw-java-sdk-1.0.0-SNAPSHOT-jar-with-dependencies.jar ./
RUN apt update -o Acquire::Check-Valid-Until=false -o Acquire::Check-Date=false

ENTRYPOINT ["java","-jar","utmtw-java-sdk-1.0.0-SNAPSHOT-jar-with-dependencies.jar"]
