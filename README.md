# Rendu microservice poller

- Rayanne Kettana
- ROUX Loïc

## Installation / Rebuild

- Requis : openjdk17 or any Java11 langage level jdk

- `mvn clean install` sur le module [userapplication](./userapplication)
- `mvn clean install` sur le module [questionapplication](./questionapplication)
- `mvn spring-boot:run` sur userapplication et questionapplication
- Ensuite on génère les clients api avec `mvn clean install` sur le module [library](./library)
- `mvn clean install` sur le module [leaderboardapplication](./library)
- `mvn spring-boot:run` sur leaderboardapplication

## Tests

- Test using collections in [./postman](postman)
- Request update and delete are not perfectly filled everywhere but essentials are ok

## Api docs

- [question](http://localhost:8081/swagger-ui/index.html)
- [leaderboard](http://localhost:8082/swagger-ui/index.html)
- [user](http://localhost:8080/swagger-ui/index.html)

## Generate api clients

`./scripts/fetch-api-docs.sh`
