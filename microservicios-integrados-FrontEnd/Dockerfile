# Usar una imagen base de Node.js
FROM node:18 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el package.json y package-lock.json
COPY package*.json ./

# Instalar las dependencias
RUN npm install

# Copiar el resto de la aplicación
COPY . .

# Construir la aplicación Angular
RUN npm run build --prod

# Usar una imagen ligera para servir la aplicación
FROM nginx:alpine

# Copiar los archivos construidos a Nginx
COPY --from=build /app/dist/proyecto-microservicios /usr/share/nginx/html

# Exponer el puerto 80
EXPOSE 80

# Comando para ejecutar Nginx
CMD ["nginx", "-g", "daemon off;"]
