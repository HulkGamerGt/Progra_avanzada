package cl.ucm.prestamos

import java.util.Scanner

/**
 * Funcion Principal: main
 * Descripcion: Punto de entrada de la aplicacion. Inicializa el entorno REPL y gestiona el flujo de lectura interactiva.
 */
fun main() {
    val scanner = Scanner(System.`in`)
    var ejecutando = true

    println("=== Sistema de Gestion de Prestamos de Activos Universitarios ===")
    
    while (ejecutando) {
        println("\n--- Menu Principal ---")
        println("1. Registrar nuevo usuario")
        println("2. Registrar nuevo recurso")
        println("3. Ejecutar prestamo")
        println("4. Salir")
        print("Ingrese su opcion: ")

        try {
            val opcion = scanner.nextInt()
            when (opcion) {
                1 -> println("Iniciando modulo de registro de usuarios...")
                2 -> println("Iniciando modulo de registro de recursos...")
                3 -> println("Iniciando modulo de prestamos...")
                4 -> {
                    println("Cerrando sistema REPL...")
                    ejecutando = false
                }
                else -> println("Opcion fuera de rango. Por favor ingrese un numero entre 1 y 4.")
            }
        } catch (e: Exception) {
            println("Error de entrada de datos. Debe ingresar un valor numerico entero.")
            scanner.nextLine() // Limpiar buffer
        }
    }
}