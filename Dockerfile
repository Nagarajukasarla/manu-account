FROM eclipse-temurin:17-jdk-alphine

WORKDIR /app

COPY pom.xml .

# Download maven dependencies
RUN mvn dependency:go-offline

#Copy source
COPY src ./src

# Build
RUN mvn clean package -DskipTests

# Run stage   if you are facing any errors then you can use jdk to debug in production
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]