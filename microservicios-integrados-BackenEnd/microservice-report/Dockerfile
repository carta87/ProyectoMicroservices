# IMAGEN MODELO
FROM openjdk:17-jdk-slim

# Instala las bibliotecas necesarias
RUN apt-get update && apt-get install -y \
    libfreetype6-dev \
    libfontconfig1 \
    && rm -rf /var/lib/apt/lists/*

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root/microservice-report

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root/microservice-report
COPY ./.mvn /root/microservice-report/.mvn
COPY ./mvnw /root/microservice-report

EXPOSE 8091

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/microservice-report/src

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests -e

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java",  "-Djava.awt.headless=true", "-jar", "/root/microservice-report/target/microservice-report-1.0-SNAPSHOT.jar"]