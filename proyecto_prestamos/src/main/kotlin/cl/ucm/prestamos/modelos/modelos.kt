package cl.ucm.prestamos.modelos

import cl.ucm.prestamos.interfaces.Prestable
import cl.ucm.prestamos.usuarios.Usuario

class Categoria(
    private val id: Int,
    private val nombre: String,
    private val descripcion: String
) {
    constructor(id: Int, nombre: String) : this(id, nombre, "Sin descripcion")

    fun getNombre(): String = nombre
    fun mostrarInfo(): String = "Categoria [ID: $id, Nombre: $nombre, Descripcion: $descripcion]"
}

abstract class ObjetoPrestable(
    protected val id: Int,
    protected val nombre: String,
    protected var disponible: Boolean,
    protected val multaPorDia: Double
) : Prestable {

    fun getId(): Int = id
    fun getNombre(): String = nombre
    fun isDisponible(): Boolean = disponible
    fun setDisponible(estado: Boolean) { this.disponible = estado }

    abstract fun calcularPlazoDias(): Int

    open fun mostrarInfo(): String {
        return "Objeto [ID: $id, Nombre: $nombre, Disponible: $disponible, Multa Diaria: $multaPorDia]"
    }

    override fun prestar(usuario: Usuario): Boolean {
        if (this.disponible) {
            this.disponible = false
            return true
        }
        return false
    }

    override fun devolver(): Boolean {
        this.disponible = true
        return true
    }
}

open class Libro(
    id: Int,
    nombre: String,
    disponible: Boolean,
    multaPorDia: Double,
    private val isbn: String,
    private val autor: String,
    private val categoria: Categoria
) : ObjetoPrestable(id, nombre, disponible, multaPorDia) {

    // Constructor secundario
    constructor(id: Int, nombre: String, isbn: String, autor: String, categoria: Categoria) : 
        this(id, nombre, true, 1000.0, isbn, autor, categoria)

    override fun calcularPlazoDias(): Int = 7
    override fun mostrarInfo(): String = super.mostrarInfo() + " | ISBN: $isbn, Autor: $autor"
}

class Sala(
    id: Int,
    nombre: String,
    disponible: Boolean,
    multaPorDia: Double,
    private val numeroSala: String,
    private val capacidad: Int,
    private val implementos: String
) : ObjetoPrestable(id, nombre, disponible, multaPorDia) {

    constructor(id: Int, nombre: String, numeroSala: String) : 
        this(id, nombre, true, 5000.0, numeroSala, 30, "Pizarra, Proyector")

    override fun calcularPlazoDias(): Int = 1 
    override fun mostrarInfo(): String = super.mostrarInfo() + " | Sala: $numeroSala, Capacidad: $capacidad"
}