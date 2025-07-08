FROM gradle:8.3-jdk17 AS builder

ARG MODULE

WORKDIR /beaver
COPY . .

RUN echo "🔍 현재 ENV MODULE 값: ${MODULE}"

RUN ./gradlew :service:${MODULE}:bootJar

FROM eclipse-temurin:17-jdk

ARG MODULE

COPY --from=builder /beaver/service/${MODULE}/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
