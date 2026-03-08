# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS build
# hoặc cụ thể: maven:3.9.9-eclipse-temurin-21 (nếu muốn Maven mới hơn)

COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Stage 2: Runtime (cũng dùng JDK 21 để chạy)
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /app/target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
