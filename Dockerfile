FROM amazoncorretto:8u372-alpine3.17
COPY ./target/customSpringBootApp-0.0.1.jar /usr/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/lib/app.jar"]