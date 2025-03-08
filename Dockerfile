FROM openjdk:17-jdk-slim
WORKDIR /oci-microservice-A01642425
COPY /target/*.jar oci-microservice-A01642425.jar
COPY /src/main/resources/Wallet_javadev101 /oci-microservice-A01642425/Wallet_javadev101
ENV TNS_ADMIN=/oci-microservice-A01642425/Wallet_javadev101
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "oci-microservice-A01642425.jar" ]