# --- Stage 1: Build the Application ---
FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /app

# Copy Gradle wrapper and Kotlin configuration files
COPY gradle/ gradle/
COPY gradlew build.gradle.kts settings.gradle.kts ./

# CRITICAL FOR KOTLIN: Fetch dependencies and compile build scripts
RUN ./gradlew dependencies --no-daemon

# Copy the actual source code
COPY src ./src

# Build the execution fat jar, skipping tests
RUN ./gradlew bootJar --no-daemon -x test

# --- Stage 2: Create the Runtime Image ---
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Create a secure, non-root user to run the application
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy only the compiled bootJar (Handling the plain jar exception)
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]