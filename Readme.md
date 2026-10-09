# Демонстрация Apache CXF

### Тестирование

#### Запуск сервиса

Сборка:
````shell
mvn clean package
````

Запуск:
````shell
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -jar target/jaxrs-1.0.0.jar
````

#### Проверка:

````shell
http http://127.0.0.1:5000/movieservice/movie/1001/
````

Ответ:

````text
HTTP/1.1 200 OK
Content-Type: application/json
Server: Jetty(9.4.12.v20180830)
Transfer-Encoding: chunked

{
"id": 1001,
"name": "Aquaman"
}
````
