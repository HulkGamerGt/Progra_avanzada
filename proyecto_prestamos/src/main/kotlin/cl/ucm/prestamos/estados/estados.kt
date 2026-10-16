package cl.ucm.prestamos.estados

import cl.ucm.prestamos.interfaces.EstadoPrestamo

class EstadoActivo : EstadoPrestamo {
    override fun nombre(): String = "Activo"
    override fun puedePrestar(): Boolean = false
}

class EstadoDevuelto : EstadoPrestamo {
    override fun nombre(): String = "Devuelto"
    override fun puedePrestar(): Boolean = true
}

class EstadoVencido(
    private val diasRetraso: Int
) : EstadoPrestamo {
    
    // Constructor secundario exigido por rubrica
    constructor() : this(0)

    override fun nombre(): String = "Vencido"
    override fun puedePrestar(): Boolean = false

    /**
     * Funcion: calcularMulta
     * Descripcion: Calcula el valor monetario de penalizacion multiplicando los dias de retraso por una tarifa base.
     * Explicacion de logica: Se asume un valor de 1500.0 por cada dia de retraso como constante del sistema.
     * Retorno: Double - Monto total de la multa calculada.
     */
    fun calcularMulta(): Double {
        val tarifaDiaria = 1500.0
        return diasRetraso * tarifaDiaria
    }
}