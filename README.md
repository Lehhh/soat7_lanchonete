# soat7_lanchonete



## Docker Compose command
### Start docker-compose
Envs:
 - POSTGRES_PASSWORD
 - POSTGRES_USER
 - POSTGRES_DB
 - APP_ENV

Example: export POSTGRES_USER=techuser

docker-compose up -d

### Stop docker-compose
docker-compose down

### Status containers in docker-compose
docker-compose ps