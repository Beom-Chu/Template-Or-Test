# Redis 테스트용 도커 명령어
```shell
docker run -p 6379:6379 --name redis -d redis:latest --requirepass "123456"
```