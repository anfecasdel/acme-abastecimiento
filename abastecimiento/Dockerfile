# Usamos una imagen base de Java 11
FROM openjdk:17-jre-slim

# Exponemos el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Copiamos el archivo JAR de la aplicación (asegúrate de que se construya antes de este paso)
COPY target/tu-aplicacion.jar app.jar

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "/app.jar"]
