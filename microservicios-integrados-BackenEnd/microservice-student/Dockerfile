# IMAGEN MODELO
FROM openjdk:17-jdk-slim

# ACTUALIZAR Y INSTALAR CURL
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root/microservice-student

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root/microservice-student
COPY ./.mvn /root/microservice-student/.mvn
COPY ./mvnw /root/microservice-student

EXPOSE 8090

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/microservice-student/src

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests -e

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/microservice-student/target/microservice-student-1.0-SNAPSHOT.jar"]