# 📚 Bookstore Modulith --- Spring Boot 3, PostgreSQL, Docker

A clean, modular, production-ready **Spring Boot 3.5 Modulith**
application with:

-   Spring Data JPA\
-   PostgreSQL 17\
-   Flyway migrations\
-   Docker & Docker Compose\
-   HikariCP connection pooling\
-   JWT Authentication\
-   Multi-profile configuration (`local`, `dev`, `prod`)\
-   Multi-stage Docker build

------------------------------------------------------------------------

## 🚀 Features

-   Modular architecture with Spring Modulith\
-   PostgreSQL database with Flyway versioning\
-   Secure JWT authentication layer\
-   Local & Docker-based development\
-   HikariCP optimized DB connection pool\
-   Profile-based config (`application-local.yml`,
    `application-dev.yml`, `application-prod.yml`)\
-   Persistent PostgreSQL data stored on Windows host

------------------------------------------------------------------------

## 🏗️ Architecture Overview

    ┌─────────────────────────────────┐
    │         Bookstore App           │
    │  Spring Boot 3 + Modulith       │
    │                                 │
    │  Modules:                       │
    │   • auth                        │
    │   • books                       │
    │   • inventory                   │
    │   • orders                      │
    │                                 │
    │  Flyway → DB Migrations         │
    │  JPA / Hibernate                │
    └─────────────────────────────────┘
                   │
                   ▼
    ┌─────────────────────────────────┐
    │         PostgreSQL 17           │
    │  Persistent Storage (Windows)   │
    │  Host Path: D:/docker-data/...  │
    └─────────────────────────────────┘

------------------------------------------------------------------------

## 🧰 Prerequisites

-   JDK 21+\
-   Maven 3.9+\
-   Docker Desktop\
-   Git

------------------------------------------------------------------------

## 📦 Build the Application

### Build the JAR:

``` bash
mvn clean package -DskipTests
```

------------------------------------------------------------------------

## 🐳 Docker Usage

### 1️⃣ Build Docker Image

``` bash
docker build -t bookstore-app .
```

Or with build arguments:

``` bash
docker build --build-arg PROFILE=dev --build-arg APP_VERSION=1.0.0 -t bookstore-app .
```

------------------------------------------------------------------------

### 2️⃣ Run Container (Standalone Mode)

#### Run with explicit DB configuration:

``` bash
docker run --rm -p 8080:8080 \
    -e SPRING_PROFILES_ACTIVE=dev \
    -e DB_URL=jdbc:postgresql://host.docker.internal:5432/bookstore \
    -e DB_USERNAME=postgres \
    -e DB_PASSWORD=1234 \
    bookstore-app
```

#### Or simply:

``` bash
docker run --rm -p 8080:8080 bookstore-app
```

------------------------------------------------------------------------

# 🐳 Docker Compose (Recommended for Local Dev)

### Start application + PostgreSQL:

``` bash
docker compose -f docker-compose.local.yml up -d
```

### Stop services:

``` bash
docker compose -f docker-compose.local.yml down
```

### View logs:

``` bash
docker compose -f docker-compose.local.yml logs -f
```

------------------------------------------------------------------------

## 🗄️ PostgreSQL Data Persistence (Windows)

Your local database is stored at:

    D:/docker-data/bookstore-postgres

This means:

✔ DB persists across container restarts\
✔ You can delete folder to "reset" DB\
✔ DB files visible on your Windows machine

------------------------------------------------------------------------

## 🔧 Environment Variables

### Used by the application:

Variable                   Purpose
  -------------------------- -----------------------------------------
`SPRING_PROFILES_ACTIVE`   Select profile (`local`, `dev`, `prod`)
`DB_URL`                   JDBC URL for PostgreSQL
`DB_USERNAME`              Database username
`DB_PASSWORD`              Database password

------------------------------------------------------------------------

## 📂 Folder Structure

    project/
     ├── src/
     ├── target/
     ├── Dockerfile
     ├── docker-compose.local.yml
     ├── pom.xml
     ├── README.md
     └── db/
         └── migration/   (Flyway .sql files)

------------------------------------------------------------------------

## 🔐 Authentication (JWT)

Default JWT config:

-   Secret: configured in `application.yml`
-   Expiration: 1 hour
-   Full JWT filter & provider included

------------------------------------------------------------------------

## 🧪 Testing the API

Use Postman or Curl:

``` bash
curl http://localhost:8080/api/books
```

Example login:

``` bash
POST /auth/login
{
  "username": "admin",
  "password": "admin123"
}
```

Use JWT token in Authorization header:

    Authorization: Bearer <token>

------------------------------------------------------------------------

## 🏁 Closing Notes

This project is structured to be:

-   Easy for local development\
-   Clean for team-based collaboration\
-   Ready to containerize into dev/prod environments\
-   Simple to extend with more modules
