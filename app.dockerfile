FROM openjdk:8u151-jre-alpine

ADD target/*.jar /srv.jar

CMD ["java", "-jar", "/srv.jar"]