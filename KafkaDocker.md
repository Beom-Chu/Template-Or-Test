# Kafka Docker

kafka의 경우 Zookeper, kafka, kafka-ui 서비스를 모두 띄워주어야 하기 때문에 Docker-compose를 활용하자.

Docker-compose 알아보기 : (https://github.com/Beom-Chu/Study/blob/main/etc/Docker%20Compose.md)

1. Docker-compose yaml 파일 생성
 ```yaml
version: '2'
services:
   zookeeper:
      image: confluentinc/cp-zookeeper:latest
      environment:
         ZOOKEEPER_SERVER_ID: 1
         ZOOKEEPER_CLIENT_PORT: 2181
         ZOOKEEPER_TICK_TIME: 2000
         ZOOKEEPER_INIT_LIMIT: 5
         ZOOKEEPER_SYNC_LIMIT: 2
      ports:
         - "22181:2181"

   kafka:
      image: confluentinc/cp-kafka:latest
      depends_on:
         - zookeeper
      ports:
         - "29092:29092"
      environment:
         KAFKA_BROKER_ID: 1
         KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
         KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
         KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
         KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
         KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
         KAFKA_GROUP_INITIAL_REBALANCE_DELAY_MS: 0

   kafka-ui:
      image: provectuslabs/kafka-ui
      container_name: kafka-ui
      ports:
         - "8081:8080"
      restart: always
      environment:
         - KAFKA_CLUSTERS_0_NAME=local
         - KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS=kafka:9092
         - KAFKA_CLUSTERS_0_ZOOKEEPER=zookeeper:2181
```
2. docker-compose 서비스 실행

    docker-compose.yml 파일이 있는 경로에서 아래 명령어 실행
```shell
$ docker-compose up
```
