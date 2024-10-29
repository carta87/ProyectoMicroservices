# IMAGEN MODELO
FROM openjdk:17-jdk-slim

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root/microservice-eureka

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root/microservice-eureka
COPY ./.mvn /root/microservice-eureka/.mvn
COPY ./mvnw /root/microservice-eureka

EXPOSE 8761

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/microservice-eureka/src

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests -e

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/microservice-eureka/target/microservice-eureka-1.0-SNAPSHOT.jar"]