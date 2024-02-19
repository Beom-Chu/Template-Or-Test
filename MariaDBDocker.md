# MariaDB 테스트용 도커 명령어
```sh
docker run -p 3306:3306 --name sample -e MARIADB_ROOT_PASSWORD=sample -d mariadb
```