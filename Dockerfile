FROM openjdk:21-jdk
COPY axpe-ecommerce-application/target/axpe-ecommerce-application-0.0.1-SNAPSHOT.jar axpe-ecommerce-application-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/axpe-ecommerce-application-0.0.1-SNAPSHOT.jar"]