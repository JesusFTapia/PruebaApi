# Etapa 1: Construcción del JAR
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con JDK liviano
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/RequestResponseManager-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]