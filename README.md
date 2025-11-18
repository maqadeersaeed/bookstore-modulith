

# Docker Commands

-e environment params are optional since we have them in 

## Build Docker

docker build --build-arg PROFILE=dev --build-arg APP_VERSION=1.0.0 -t bookstore-app .
or
docker build -t bookstore-app .
or
docker build -t bookstore-app:1.0.0 .


## Run Docker
docker run \
-e SPRING_PROFILES_ACTIVE=prod \
-e DB_URL=jdbc:postgresql://prod-db:5432/bookstore \
myapp

OR Simply 

docker run --rm -p 8080:8080 bookstore-app