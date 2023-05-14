FROM amazoncorretto:17-alpine3.17
ARG APP_VERSION
COPY ./target/customSpringBootApp-${APP_VERSION}.jar /usr/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/lib/app.jar"]