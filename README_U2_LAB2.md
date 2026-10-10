 BiblioApp

Integrantes: (Diego Solis R. , Joaquin Vasquez G.) LAB 1 && (Javier Flores E. , Benjamin Ruz B.) LAB 3
Sección: LAB 1 - LAB 3. 
Asignatura: Programación Avanzada INF-223  
Docentes: Bruno Faúndez Valenzuela  
Fecha:9 / 10 / 2026


¿De qué trata el proyecto?

BiblioApp es un sistema de consola hecho en Kotlin para gestionar los préstamos de una biblioteca universitaria. La idea es que el bibliotecario pueda registrar qué recurso se presta, a quién y por cuánto tiempo, sin tener que andar anotando todo a mano en cuadernos separados.

La biblioteca no solo presta libros: también tesis, casilleros y salas de estudio. Hoy cada uno de esos préstamos se registra por separado, lo que genera filas, errores y pérdida de tiempo. Con el sistema se centraliza todo en una sola aplicación de consola.

- Problema que resuelve

Actualmente los préstamos se anotan en distintos cuadernos según el tipo de recurso. Esto provoca:

- Errores al transcribir los datos.
- No se sabe en el momento qué recursos están disponibles.
- El préstamo de casilleros y salas es especialmente lento porque hay que verificar todo a mano.

El sistema reemplaza esos cuadernos por un registro único, valida los permisos de cada tipo de usuario y calcula las multas por atraso.

- Usuarios del sistema

 Usuario  Qué hace en el sistema 

 Bibliotecario:  Administra el sistema. Registra préstamos y devoluciones de cualquier recurso. 
 Docente:  Puede pedir libros, tesis, casilleros y salas. 
 Estudiante:  Solo puede pedir libros y casilleros. 


Entidades principales

- Usuario: persona que interactúa con la biblioteca. Se divide en Bibliotecario, Docente y Estudiante.
- Recurso: cualquier cosa que se pueda prestar. Se divide en Libro, Tesis, Casillero y Sala.
- Categoría: agrupa los libros según su área temática.
- Préstamo: registra qué recurso se prestó, a quién, la fecha y su estado.
- Multa: se genera si un préstamo se devuelve atrasado.



 Modelo UML
- <img width="1563" height="639" alt="BiblioApp" src="https://github.com/user-attachments/assets/18b4e3a3-b4a4-4597-b362-fa72a794b5fb" />
