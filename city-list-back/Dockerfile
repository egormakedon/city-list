FROM maven:3.8.3-openjdk-11-slim AS build

WORKDIR /home/city-list/

COPY ./ /home/city-list/

RUN mvn package

FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app

COPY --from=build /home/city-list/target/city-list.jar /opt/app

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/city-list.jar"]
