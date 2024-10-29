# IMAGEN MODELO
FROM openjdk:17-jdk-slim

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root/microservice-gateway

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root/microservice-gateway
COPY ./.mvn /root/microservice-gateway/.mvn
COPY ./mvnw /root/microservice-gateway

EXPOSE 8080

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/microservice-gateway/src

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests -e

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/microservice-gateway/target/microservice-gateway-1.0-SNAPSHOT.jar"]