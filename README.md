

# Docker Commands

-e environment params are optional since we have them in 

## Build Docker

docker build --build-arg PROFILE=dev --build-arg APP_VERSION=1.0.0 -t bookstore-app .
or
docker build -t bookstore-app .
or
docker build -t bookstore-app:1.0.0 .


## Run Docker
docker run --rm -p 8080:8080 \
    -e SPRING_PROFILES_ACTIVE=dev \
    -e DB_URL=jdbc:postgresql://host.docker.internal:5432/bookstore \
    -e DB_USERNAME=postgres \
    -e DB_PASSWORD=1234 \
    bookstore-app

docker run --rm -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev -e DB_URL=jdbc:postgresql://host.docker.internal:5432/bookstore -e DB_USERNAME=postgres -e DB_PASSWORD=1234 bookstore-app

OR Simply 

docker run --rm -p 8080:8080 bookstore-app


# Dccker Compose

docker compose -f docker-compose.local.yml up -d

