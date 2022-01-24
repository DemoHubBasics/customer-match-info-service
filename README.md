# customer-match-info-service
Microservice built on springboot to fetch licensed matches for given customer Id.
Application uses noSql mongoDb as the database.
Dockerized mongo express used as data service provider.
Config to setup mongo express on your docker:
put below yaml file to class path of the client service with docker running on your system.

docker-compose.yaml
==================================
version: "3.8"
services:
  mongodb:
    image: mongo
    container_name: mongodb
    ports:
      - 27017:27017
    volumes:
      - data:/data
    environment:
      - MONGO_INTITDB_ROOT_USERNAME=rootuser
      - MONGO_INTITDB_ROOT_PASSWORD=rootpass
  mongo-express:
    image: mongo-express
    container_name: mongo-express
    restart: always

    ports:
      - 8081:8081
    environment:
      - ME_CONFIG_MONGODB_ENABLE_ADMIN=true
      #      - ME_CONFIG_MONGODB_ADMINUSERNAME=root
#      - ME_CONFIG_MONGODB_ADMINPASSWORD=rootpassword
      - ME_CONFIG_MONGODB_SERVER=mongodb
volumes:
  data: {}
networks:
  default:
    name: mongodb_network
    
===========================================

Application uses Netflix Eureka Service Discovery to avoid hardcoded urls for microservices.
http://localhost:8085/getMatches/61ed92911ab48803cc89587c?summaryType=AvBTime    ---> Url to get liscensed matches 
