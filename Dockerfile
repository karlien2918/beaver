# ──────────────── [ Stage 1: Build with Gradle ] ────────────────
FROM gradle:8.3-jdk17 AS builder

WORKDIR /beaver
COPY . .

# 빌드 실행 (bootJar는 Spring Boot)
RUN ./gradlew :service:payment-service:bootJar

# ──────────────── [ Stage 2: Runtime Image ] ────────────────
FROM eclipse-temurin:17-jdk

WORKDIR /beaver

# 빌드 결과만 복사
COPY --from=builder /beaver/service/payment-service/build/libs/*.jar payment-service.jar

ENTRYPOINT ["java", "-jar", "payment-service.jar"]
