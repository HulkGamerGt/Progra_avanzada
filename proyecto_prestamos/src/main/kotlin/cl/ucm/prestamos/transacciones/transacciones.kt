package cl.ucm.prestamos.transacciones

import cl.ucm.prestamos.interfaces.EstadoPrestamo
import cl.ucm.prestamos.modelos.ObjetoPrestable
import cl.ucm.prestamos.usuarios.Usuario

class Multa(
    private val monto: Double,
    private val diasAtraso: Int,
    private var pagada: Boolean
) {
    fun getMonto(): Double = monto
    fun isPagada(): Boolean = pagada
    fun marcarPagada() { this.pagada = true }
    fun mostrarInfo(): String = "Multa [Monto: $monto, Dias Atraso: $diasAtraso, Pagada:$pagada]"
}

class Prestamo(
    private val id: Int,
    private val fechaPrestamo: String,
    private val fechaDevolucion: String,
    private val diasPrestamo: Int,
    private var estado: EstadoPrestamo,
    private val usuario: Usuario,
    private val objetoPrestable: ObjetoPrestable
) {
    private var multaGenerada: Multa? = null

    fun getId(): Int = id

    /**
     * Funcion: calcularAtraso
     * Descripcion: Calcula los dias de diferencia entre la fecha limite de devolucion y la fecha actual.
     * Explicacion de logica: En esta fase inicial (Semana 2), se implementa un retorno estatico para probar 
     * el cambio de estados, ya que el manejo de fechas reales requiere librerias externas prohibidas por la rubrica.
     * Retorno: Int - Cantidad de dias de atraso.
     */
    fun calcularAtraso(): Int {
        return 0 
    }

    fun cambiarEstado(nuevoEstado: EstadoPrestamo) {
        this.estado = nuevoEstado
    }

    fun mostrarInfo(): String {
        return "Prestamo [ID: $id, Estado:${estado.nombre()}, Usuario: ${usuario.getNombre()}, Objeto:${objetoPrestable.getNombre()}]"
    }
}