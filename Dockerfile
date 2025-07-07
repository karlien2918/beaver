# ──────────────── [ Stage 1: Build with Gradle ] ────────────────
FROM gradle:8.3-jdk17 AS builder

ARG MODULE

WORKDIR /beaver
COPY . .

# 빌드 실행 (bootJar는 Spring Boot)
RUN ./gradlew :service:${MODULE}:bootJar

FROM eclipse-temurin:17-jdk

COPY --from=builder /beaver/service/${MODULE}/build/libs/*.jar ${MODULE}.jar

ENTRYPOINT ["java", "-jar", "${MODULE}.jar"]
