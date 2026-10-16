package cl.ucm.prestamos.usuarios

abstract class Usuario(
    protected val id: Int,
    protected val nombre: String,
    protected val email: String,
    protected val activo: Boolean
) {
    fun getId(): Int = id
    fun getNombre(): String = nombre
    fun isActivo(): Boolean = activo

    open fun mostrarInfo(): String = "Usuario [ID: $id, Nombre: $nombre, Email: $email, Activo: $activo]"
    
    abstract fun limitePrestamos(): Int
}

class Estudiante(
    id: Int,
    nombre: String,
    email: String,
    activo: Boolean,
    private val carrera: String,
    private val matricula: String
) : Usuario(id, nombre, email, activo) {

    // Constructor secundario requerido por rubrica
    constructor(id: Int, nombre: String, matricula: String) : 
        this(id, nombre, "correo@ucm.cl", true, "Ingenieria Civil Informatica", matricula)

    fun getCarrera(): String = carrera
    override fun limitePrestamos(): Int = 3
}

class Docente(
    id: Int,
    nombre: String,
    email: String,
    activo: Boolean,
    private val departamento: String,
    private val antiguedad: Int
) : Usuario(id, nombre, email, activo) {

    constructor(id: Int, nombre: String, departamento: String) : 
        this(id, nombre, "docente@ucm.cl", true, departamento, 1)

    fun getDepartamento(): String = departamento
    override fun limitePrestamos(): Int = 10
}