import kotlin.collections.List
import kotlin.collections.Set   

data class Sala(val id: String, val cap: Int, val eq: Set<String>)
data class Sol(val idSol: String, val hr: String, val asis: Int, val eqReq: Set<String>)

data class Asig(val idSol: String, val idSala: String, val hr: String)
data class Rchz(val idSol: String, val mtv: String)

// Estado acumulado del sistema: guarda la lista de asignaciones exitosas y las rechazadas
data class Est(val asigs: List<Asig> = emptyList(), val rchzs: List<Rchz> = emptyList())

