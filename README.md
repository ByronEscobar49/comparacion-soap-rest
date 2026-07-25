# Comparación SOAP vs REST

Proyecto académico que implementa una misma operación (**saludar a una persona**) 
utilizando dos estilos de servicios web distintos: **SOAP** (Contract-First) y **REST**.

## 📋 Requisitos del proyecto

- **Lenguaje:** Java 17 (JDK 17)
- **Gestor de dependencias:** Maven (proyecto multi-módulo)
- **Framework:** Spring Boot 3.2.5
  - Módulo `soap`: Spring-WS + JAXB
  - Módulo `rest`: Spring Web

## ▶️ Instrucciones para ejecutar el proyecto

### Requisitos previos
- JDK 17 instalado
- Maven instalado y agregado al PATH (verificar con `mvn -v`)

### Levantar el servicio SOAP (puerto 8081)

bash
mvn spring-boot:run -pl soap

### Levantar el servicio REST (puerto 8082)
En otra terminal:

bash
mvn spring-boot:run -pl rest

Ambos servicios pueden correr **simultáneamente**, ya que usan puertos distintos.

## 🧼 Cómo consumir el servicio SOAP

**Contrato (WSDL):** una vez levantado el servicio, disponible en:
http://localhost:8081/ws/saludo.wsdl

**Endpoint de operación:**
POST http://localhost:8081/ws
Content-Type: text/xml; charset=utf-8

**Body (XML):**
xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                   xmlns:sch="http://umg.edu.gt.desarrollo.web/soap/saludo">
   <soapenv:Header/>
   <soapenv:Body>
      <sch:saludarRequest>
         <sch:nombre>Byron</sch:nombre>
      </sch:saludarRequest>
   </soapenv:Body>
</soapenv:Envelope>

**Respuesta esperada:**
xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Body>
      <ns2:saludarResponse xmlns:ns2="http://umg.edu.gt.desarrollo.web/soap/saludo">
         <ns2:mensaje>Hola, Byron! Bienvenido al servicio SOAP.</ns2:mensaje>
      </ns2:saludarResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>


## 🌐 Cómo consumir el servicio REST

**Endpoint:**

GET http://localhost:8082/api/saludo/{nombre}

**Ejemplo:**

GET http://localhost:8082/api/saludo/Byron

**Respuesta esperada (200 OK):**
json
{
    "mensaje": "Hola, Byron! Bienvenido al servicio REST."
}


## 🧪 Pruebas realizadas

Ambos servicios fueron probados usando **Postman**.

### Prueba SOAP
[CAPTURA AQUÍ ]

### Prueba REST
[CAPTURA AQUÍ ]

## 🔍 Comparación entre SOAP y REST

Al desarrollar ambos servicios notamos diferencias claras en el esfuerzo de 
implementación. SOAP requirió definir primero un contrato formal (XSD), configurar 
la generación del WSDL, mapear el enrutamiento por contenido del mensaje 
(`@PayloadRoot`) y construir manualmente el sobre XML para cada prueba, lo que 
implicó más configuración y piezas moviéndose. REST, en cambio, fue considerablemente 
más rápido de implementar: bastó con una URL, un verbo HTTP y un objeto Java simple, 
sin contrato previo ni generación de código. En nuestra experiencia, REST fue más 
sencillo de implementar y depurar, aunque también enfrentamos un error específico de 
Java (nombres de parámetros no disponibles en tiempo de ejecución) que no habría 
ocurrido en SOAP, donde los campos vienen definidos rígidamente por el XSD. 
Consideraríamos usar SOAP en sistemas empresariales que exigen contratos estrictos, 
transacciones complejas o alta seguridad (por ejemplo, servicios bancarios o 
gubernamentales), y usaríamos REST para APIs web modernas, aplicaciones móviles o 
cualquier escenario donde se priorice velocidad de desarrollo, ligereza y facilidad 
de consumo.

## 🤖 Uso de Inteligencia Artificial

Se utilizó Claude (Anthropic) como asistente durante el desarrollo del proyecto, 
principalmente para guía paso a paso en la configuración de Spring-WS y Spring Web.
