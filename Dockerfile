FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Download maven dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source
COPY src ./src

# Build
RUN mvn clean package -DskipTests

# Run stage if you are facing any errors then you can use jdk to debug in production
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]