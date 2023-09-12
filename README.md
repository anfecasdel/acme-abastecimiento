# Proyecto ACME Abastecimiento

Este proyecto implementa un servicio REST para el ciclo de abastecimiento de la compañía ACME. Permite a la tienda de la carrera 70 enviar información de pedidos a través de esta API y recibir información del sistema de envío de pedidos a través de un servicio SOAP.

## Requisitos Previos

- Java JDK 11 o superior
- Apache Maven
- Docker (si deseas ejecutar la aplicación en contenedores)

## Configuración del Proyecto

1. Clone este repositorio:

   ```shell
   git clone https://github.com/tu-usuario/acme-abastecimiento.git
   cd acme-abastecimiento

Configura las propiedades de la aplicación en el archivo src/main/resources/application.properties. Específicamente, establece el valor de acme.endpoint con la URL del servicio SOAP externo.

Ejecuta la aplicación Spring Boot:

shell
Copy code
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.

Uso de la API REST
Enviar un Pedido
Endpoint: /api/pedidos/enviar
Método: POST
Cuerpo de la Solicitud: JSON con los datos del pedido (ver ejemplo en la sección siguiente).
Respuesta: JSON con los detalles del envío del pedido.
Ejemplo de Solicitud JSON:
json
Copy code
{
  "pedido": "75630275",
  "Cantidad": "1",
  "EAN": "00110000765191002104587",
  "Producto": "Armario INVAL",
  "Cedula": "1113987400",
  "Direccion": "CR 72B 45 12 APT 301"
}
Ejemplo de Respuesta JSON:
json
Copy code
{
  "codigoEnvio": "80375472",
  "estado": "Entregado exitosamente al cliente"
}
