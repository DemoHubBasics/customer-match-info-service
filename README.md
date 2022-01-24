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
              - ME_CONFIG_MONGODB_SERVER=mongodb
        volumes:
          data: {}
        networks:
          default:
            name: mongodb_network

===========================================

Application uses Netflix Eureka Service Discovery to avoid hardcoded urls for microservices.
http://localhost:8085/getMatches/61ed92911ab48803cc89587c?summaryType=AvBTime    ---> Url to get liscensed matches 


Expected Response from the service after successful transaction

                {
                    "userId": "61ed92911ab48803cc89587c",
                    "customerName": "Alex",
                    "matches": [
                        {
                            "id": "61ed8dbc1ab48803cc895870",
                            "startDate": "2022-01-24T02:55:13.21",
                            "playerA": "A",
                            "playerB": "B",
                            "summary": "Started 624 minutes ago."
                        },
                        {
                            "id": "61ed8e591ab48803cc895872",
                            "startDate": "2022-01-26T15:55:13.21",
                            "playerA": "A",
                            "playerB": "B",
                            "summary": "Starts in 2 days."
                        }
                    ]
                }
