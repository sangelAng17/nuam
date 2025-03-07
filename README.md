# Autor : Angel Santiago Hernandez 
# PRUEBA TECNICA NUAM 

# Desafio

<p>
 Prueba de conocimientos en Java

## 1. Ejercicio Práctico de Programación Orientada a Objetos en Java

Se requiere un sistema para una biblioteca. Se deben modelar las clases necesarias para gestionar los diferentes tipos de recursos que tiene la biblioteca, como libros y revistas. Se debe aplicar los conceptos de programación orientada a objetos en este escenario.Define una clase Recurso que debe tener los siguientes atributos privados:

* id (int): identificador único del recurso.
* titulo (String): título del recurso.
* disponible (boolean): indica si el recurso está disponible para préstamo

La clase debe tener un constructor para inicializar estos atributos y los métodos públicos para
acceder a ellos. Define las clases Libro y Revista:

* Ambas clases deben heredar de la clase Recurso.
* La clase Libro debe tener un atributo adicional: autor (String): autor del libro.
* La clase Revista debe tener un atributo adicional: numero (int): número de la revista.
* La clase Revista debe tener un atributo adicional: tipo (tipoRevista): define el tipo derevista (mínimo 5) y deben ser definidos por un enumerado.
* Cada clase debe tener su propio constructor para inicializar sus atributos y sobrescribir el método toString() para proporcionar una representación de cadena adecuada del objeto.

PRUEBA TÉCNICA DEV JAVA
## 1. Contexto
La Bolsa de Valores de Colombia requiere sus servicios para desarrollar una API Rest para su sistema
de mercado de valores. Hoy en día ya existen 2 APIs que permiten crear, consultar, actualizar y
eliminar usuarios y empresas. La idea es que usted pueda desarrollar una nueva API que permita a los
usuarios comprar y vender acciones de diferentes empresas.
Para este proyecto, se debe utilizar Java como lenguaje de programación y Spring Boot como
framework.
## 2. Requerimientos
El servicio debe tener las siguientes funcionalidades:
1. Registrar una transacción de compra o venta de acciones de una empresa.
2. Consultar todas las transacciones realizadas por un usuario.
3. Consultar todas las transacciones realizadas de una empresa en particular.
4. Consultar todas las transacciones en un rango de fechas.
5. Consultar el resumen de las transacciones realizadas por usuario indicando: total acciones
compradas, total acciones vendidas, precio total de compras y precio total de ventas.
6. Consultar el resumen de compras y ventas de las acciones realizadas para una empresa
específica, indicando cantidad de acciones vendidas, compradas y precio total vendido y
comprado.
7. Consultar el ranking de las 10 empresas cuyas acciones fueron las más vendidas y compradas.
8. Consultar el ranking de los 10 usuarios que más compraron y vendieron acciones.
El modelo de datos para una transacción debe incluir los siguientes campos:
• Identificador de transacción
• Identificador de usuario
• Identificador de empresa
• Tipo de transacción (compra o venta)
• Cantidad de acciones
• Precio por acción
• Fecha y hora de la transacción
## 3. Consideraciones técnicas
• Se debe utilizar como base el código entregado al momento de la prueba.
• La nueva API debe ir en un Controlador Rest aparte a los 2 ya existentes.
• Debe haber un manejo adecuado de las excepciones.
• Se deben seguir las buenas prácticas de programación y documentar adecuadamente el
código.
Entregables
1. Código fuente del servicio desarrollado.
2. Documentación del código fuente.
Evaluación
Se evaluará lo siguiente:
1. Conocimientos básicos de Java.
2. Conocimientos de Spring Boot y JPA.
3. Conocimientos de bases de datos.
4. Solución propuesta.
5. Manejo adecuado de excepciones.
6. Buenas prácticas de programación.
7. Documentación del código.
8. Solución de un error en el código proporcionado.
9. Sugerencia al código proporcionado.
