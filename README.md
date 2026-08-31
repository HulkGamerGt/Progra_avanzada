# Programacion_avanzada

# Sistema de Asignacion de Salas - Paradigma Funcional

Este repositorio contiene la implementacion minima ejecutable del caso de estudio de asignacion de salas para la Evaluacion 1 de la asignatura INF-223 Programacion Avanzada (Universidad Catolica del Maule). El proyecto esta desarrollado bajo el Paradigma Funcional utilizando Kotlin.

## Concepto Diferencial: Clausura Lexica

El nucleo de esta implementacion se basa en el uso de clausuras (closures), las cuales permiten que las funciones de orden superior capturen y accedan a variables de su entorno externo. Esto evita el uso de estado nombrado mutable o variables globales, manteniendo el determinismo y la pureza del flujo.

## Requisitos del Sistema

* Java Development Kit (JDK) 17 o superior.
* Compilador de Kotlin (kotlinc) instalado en la linea de comandos o IntelliJ IDEA.

## Instrucciones de Compilacion y Ejecucion

Para verificar la ejecucion en una maquina limpia, siga los siguientes pasos desde la terminal:

1. Clonar el repositorio de forma local:
   git clone https://github.com/HulkGamerGt/Progra_avanzada

2. Desplazarse al directorio del proyecto:
   cd Progra_avanzada

3. Compilar el archivo fuente generando el archivo ejecutable JAR:
   kotlinc main.kt -include-runtime -d AsignacionSalas.jar

4. Ejecutar la aplicacion:
   java -jar AsignacionSalas.jar

## Identificacion de los Puntos Clave del Paradigma

El codigo fuente incluye comentarios explicitos en los tres puntos donde el concepto diferencial determina la solucion:

1. Punto 1 (Funcion procFlujo - Expresion fold): La clausura pasada a fold captura el catalogo de salas (cat) del entorno externo, permitiendo su consulta iterativa sin depender de un estado global.
2. Punto 2 (Funcion procFlujo - Expresion firstOrNull): La clausura interna captura de manera dinamica la solicitud actual (solAct) y el estado acumulado (estAct) para evaluar restricciones en tiempo de ejecucion sin mutar datos.
3. Punto 3 (Funcion cumpleReq - Expresion all): La clausura en la funcion de orden superior all captura el equipamiento de la sala (sl.eq) para aislar la verificacion de subconjuntos.

## Enlaces a Recursos Obligatorios

* Video Demostrativo (Maximo 5 minutos):[https://github.com/HulkGamerGt/Progra_avanzada/blob/main/Paradigmas_de_la_programacion_codigo.mp4]

* Bitacora de Interaccion con Inteligencia Artificial (Normativa Articulo 67): [https://share.gemini.google/aMOxhTtNSqMq]

## Integrantes del Equipo

* Joaquin Vasquez Gomez
* Diego Solis Rojas
* Javier Flores Espindola
* Camilo Riffo Cordova
* Isidora Hormazabal Gallegos

Académico: Nicolás A. Reyes Reyes
Fecha de Entrega: 31 de agosto de 2026

