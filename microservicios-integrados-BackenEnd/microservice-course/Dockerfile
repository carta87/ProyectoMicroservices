FROM openjdk:17-jdk-slim

# ACTUALIZAR Y INSTALAR CURL
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Definir directorio raíz de nuestro contenedor
WORKDIR /root/microservice-course

# Copiar y pegar archivos dentro del contenedor
COPY ./pom.xml /root/microservice-course
COPY ./.mvn /root/microservice-course/.mvn
COPY ./mvnw /root/microservice-course

# Descargar las dependencias
RUN ./mvnw dependency:go-offline

# Copiar el código fuente dentro del contenedor
COPY ./src /root/microservice-course/src

# Construir nuestra aplicación
RUN ./mvnw package -DskipTests -e

# Exponer el puerto
EXPOSE 9090

# Levantar nuestra aplicación cuando el contenedor inicie
ENTRYPOINT ["java","-jar","/root/microservice-course/target/microservice-course-1.0-SNAPSHOT.jar"]
