# =======================
# Build Stage
# =======================
FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# =======================
# Runtime Stage
# =======================
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# ---- Build-time args (optional defaults) ----
ARG PROFILE=dev
# ARG APP_VERSION=1.0.0
# LABEL app.version="${APP_VERSION}"

# Copy built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# ========= Runtime envs (can be overridden with -e) =========
# Default profile (can override: -e SPRING_PROFILES_ACTIVE=prod)
ENV SPRING_PROFILES_ACTIVE=${PROFILE}
# ENV JAR_VERSION=${APP_VERSION}

# Match your Postgres settings from application-prod.yml
ENV DB_URL=jdbc:postgresql://localhost:5432/bookstore \
    DB_USERNAME=postgres \
    DB_PASSWORD=1234 \
    JWT_SECRET=THIS_IS_A_DEV_SECRET_CHANGE_ME


# ========= Start command =========
# CMD java -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} app.jar
CMD ["sh", "-c", "java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -jar app.jar"]