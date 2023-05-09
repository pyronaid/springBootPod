FROM amazoncorretto:17-alpine3.17
COPY ./target/customSpringBootApp-0.0.2.jar /usr/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/lib/app.jar"]