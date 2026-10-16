package cl.ucm.prestamos.interfaces

import cl.ucm.prestamos.usuarios.Usuario

/**
 * Interfaz Prestable
 * Define el contrato base para cualquier entidad que pueda ser sujeta a un préstamo.
 */
interface Prestable {
    /**
     * Funcion: prestar
     * Descripcion: Valida y ejecuta la accion de asignar un recurso a un usuario.
     * Parametros: usuario (Usuario) - La entidad de usuario que solicita el prestamo.
     * Retorno: Boolean - Verdadero si el prestamo se aprueba, falso en caso contrario.
     */
    fun prestar(usuario: Usuario): Boolean

    /**
     * Funcion: devolver
     * Descripcion: Ejecuta la accion de retornar el recurso al inventario disponible.
     * Retorno: Boolean - Verdadero si la devolucion es exitosa.
     */
    fun devolver(): Boolean
}

/**
 * Interfaz EstadoPrestamo
 * Define el contrato para el Patron de Diseño State, regulando el comportamiento del prestamo segun su ciclo de vida.
 */
interface EstadoPrestamo {
    /**
     * Funcion: nombre
     * Descripcion: Retorna el identificador en texto del estado actual.
     * Retorno: String - Nombre del estado.
     */
    fun nombre(): String

    /**
     * Funcion: puedePrestar
     * Descripcion: Determina si bajo este estado el recurso puede ser prestado nuevamente.
     * Retorno: Boolean - Verdadero si esta habilitado para prestamo.
     */
    fun puedePrestar(): Boolean
}