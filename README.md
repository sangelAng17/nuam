# Autor : Angel Santiago Hernandez 
# PRUEBA TECNICA NUAM 

# Desafio

<p>
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


# Requisitos

 - openjdk version "17.0.2" 2022-01-18
 - OpenJDK Runtime Environment (build 17.0.2+8-86)
 - OpenJDK 64-Bit Server VM (build 17.0.2+8-86, mixed mode, sharing)
 - Postgress

# Instalacion
Clonar el repositorio de [https://github.com/sangelAng17/pruebaTecnica.git](https://github.com/sangelAng17/nuam.git)

# DIAGRAME ENTIDAD RELACION 

![image](https://github.com/user-attachments/assets/700d933f-af63-4df0-85a3-63fe9e35ce83)


# DLL DATABASE

```SQL
  
 -- DROP SCHEMA nuam;

CREATE SCHEMA nuam AUTHORIZATION postgres;

-- Drop table

-- DROP TABLE nuam.company;

CREATE TABLE nuam.company (
	nit int8 NULL,
	"name" varchar NULL,
	id serial4 NOT NULL
);

-- Drop table

-- DROP TABLE nuam.stockexchange;

CREATE TABLE nuam.stockexchange (
	idcompany int8 NULL,
	stock int8 NULL,
	available int8 NULL,
	prices varchar NULL,
	currency varchar NULL,
	id serial4 NOT NULL
);

-- Drop table

-- DROP TABLE nuam.transactions;

CREATE TABLE nuam.transactions (
	id_user int8 NULL,
	id_stockexchange int8 NULL,
	amount int8 NULL,
	date_transaction date NULL,
	type_transaction varchar NULL,
	id serial4 NOT NULL
);

-- Drop table

-- DROP TABLE nuam.usern;

CREATE TABLE nuam.usern (
	first_name varchar(255) NULL,
	second_name varchar(255) NULL,
	type_document varchar(255) NULL,
	"document" varchar(255) NULL,
	id serial4 NOT NULL
);

```
