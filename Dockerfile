# Stage 1: Build với Maven
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Copy source code
COPY . /app

# Đặt working directory
WORKDIR /app

# Build project, skip test để nhanh hơn (bạn có thể bỏ -DskipTests nếu cần chạy test)
RUN mvn clean package -DskipTests

# Stage 2: Runtime image nhẹ
FROM eclipse-temurin:17-jdk-alpine

# Copy file JAR từ stage build
COPY --from=build /app/target/*.jar /app.jar

# Expose port (nếu app Spring Boot hoặc tương tự dùng 8080)
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/app.jar"]
