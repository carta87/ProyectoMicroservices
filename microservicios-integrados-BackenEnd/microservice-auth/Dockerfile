# IMAGEN MODELO
FROM eclipse-temurin:21.0.3_9-jdk

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root/microservice-auth

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root/microservice-auth
COPY ./.mvn /root/microservice-auth/.mvn
COPY ./mvnw /root/microservice-auth

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/microservice-auth/src

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/microservice-auth/target/microservice-auth-0.0.1-SNAPSHOT.jar"]