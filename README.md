# Spring Boot CV porfolio

Este proyecto sirve para proveer y consumir un resumen de la educacion, experiencia y habilidades que una persona posee.
En el podras agregar, borrar y actualizar mediante servicios REST y almacenarlos en la Base De Datos lo siguiente elementos:

1. Tu educación alcanzada, donde podras describir el titulo, la institucion y la fecha de inicio y finalizacion de tu estudio.
2. Tu experiencia, donde podras informar tu rol desempeñado su fecha de inicio y de finalización.
3. Tus habilidades, las cuales se clasifican en IT Lenguaje, Idiomas y Otras. Podras indicar por cada habilidad alcanzada el maximo nivel alcanzado.

## Tecnologias usadas
1. Java 8
2. Maven 3
3. Spring boot 2.6.4
4. Openapi 1.6.6
5. MySQL

## Como ejecutarlo

    mvn clean install

    java -jar cv-porfolio-zoppi-0.0.1-SNAPSHOT.jar

## Swagger
Para ver las APIs documentadas:


    http://localhost:8080/swagger-ui/index.html

## API ejemplos

### Request
curl -X 'POST' \
  'http://localhost:8080/person' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Juana",
  "surname": "Perez",
  "description": "Contadora Publica"
}'

### Response
curl -X 'POST' \
  'http://localhost:8080/experience' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "rol": "Analista de Impuestos",
  "startDate": "2012-03-31",
  "endDate": "2013-10-31",
  "personId": 1
}'