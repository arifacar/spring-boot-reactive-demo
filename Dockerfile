FROM openjdk:17-oracle

EXPOSE 8081

ADD reactive-api/build/libs/spring-boot-reactive-demo-1.0.0-plain.jar spring-boot-reactive-demo.jar

ENTRYPOINT ["java","-jar","spring-boot-reactive-demo.jar"]