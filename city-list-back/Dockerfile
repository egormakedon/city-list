FROM maven:3.8.3-openjdk-11-slim AS build

WORKDIR /app

COPY . /app

RUN mvn package

FROM adoptopenjdk:11-jre-hotspot

RUN mkdir -p /opt/app/data

COPY --from=build /app/target/city-list.jar /opt/app

COPY --from=build /app/src/main/resources/db/data /opt/app/data

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/city-list.jar"]
