FROM maven:3.8.1-jdk-11-openj9

WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean -U package
ENTRYPOINT ["java", "-jar", "target/bitcoin-price-index.jar"]
