# ECOMMERCE APP

Este proyecto es una demo.

## Java

Se usa la versión **21** de java.

## Ejecución en local

Se puede ejecutar la aplicación si ningún perfil activo, el `application.yml` tiene valores por defecto para funcionar
en local.

El perfil local se puede activar para ver más trazas de logs.

El context path es `ecommerce`,

Una ejecución de ejemplo,

```http request
GET http://localhost:8080/ecommerce/prices?activationDate=2020-06-14T10%3A00%3A00&productId=35455&brandId=1
```

## Base de datos

Se usa una base de datos en memoria, no hace falta ninguna configuración adicional.

Se cargan unos pocos datos de prueba al inicio.

Se pueden ver los scripts de inicialización en el módulo de liquibase.

## Docker

Se adjunta un **DockerFile** que permite construir una imagen de la aplicación en docker.

Hay que hacer un build previo para generar el jar.

**BUILD**

```shell
docker build --tag=axpe-ecommerce-application:0.0.1-SNAPSHOT .
```

**RUN**

```shell
docker run -p8080:8080 -d axpe-ecommerce-application:0.0.1-SNAPSHOT
```