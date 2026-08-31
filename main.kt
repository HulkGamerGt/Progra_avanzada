import kotlin.collections.List
import kotlin.collections.Set   

data class Sala(val id: String, val cap: Int, val eq: Set<String>)
data class Sol(val idSol: String, val hr: String, val asis: Int, val eqReq: Set<String>)

data class Asig(val idSol: String, val idSala: String, val hr: String)
data class Rchz(val idSol: String, val mtv: String)

// Estado acumulado del sistema: guarda la lista de asignaciones exitosas y las rechazadas
data class Est(val asigs: List<Asig> = emptyList(), val rchzs: List<Rchz> = emptyList())

fun main() {
    val catSalas = listOf(
        Sala("S1", 30, setOf("Proyector", "Pizarra")),
        Sala("S2", 15, setOf("TV")),
        Sala("S3", 50, setOf("Proyector", "Pizarra", "Audio"))
    )

    val flujoSols = listOf(
        Sol("Req1", "10:00", 20, setOf("Proyector")),
        Sol("Req2", "10:00", 10, setOf("TV")),
        Sol("Req3", "10:00", 40, setOf("MacBook")),
        Sol("Req4", "10:00", 25, setOf("Proyector"))
    )

    val resFinal = procFlujo(flujoSols, catSalas)

    println("Asignaciones Aceptadas:")
    resFinal.asigs.forEach { println(" -> Solicitud ${it.idSol} en Sala ${it.idSala} a las ${it.hr}") }

    println("\nSolicitudes Rechazadas:")
    resFinal.rchzs.forEach { println(" -> Solicitud ${it.idSol} rechazada. Motivo: ${it.mtv}") }
}

fun procFlujo(sols: List<Sol>, cat: List<Sala>): Est {
    
    return sols.fold(Est()) { estAct, solAct ->
        
        val salaOpt = cat.firstOrNull { sl ->
            cumpleReq(sl, solAct) && isDisp(sl, solAct.hr, estAct.asigs)
        }

        if (salaOpt != null) {
            val nvaAsig = Asig(solAct.idSol, salaOpt.id, solAct.hr)
            Est(estAct.asigs + nvaAsig, estAct.rchzs)
        } else {
            
            val cumpleCapEq = cat.any { sl -> cumpleReq(sl, solAct) }
            val motivo = if (cumpleCapEq) "Sala idónea ocupada en el horario ${solAct.hr}"
                         else "Capacidad o equipamiento insuficiente en catálogo"

            val nvoRchz = Rchz(solAct.idSol, motivo)
            Est(estAct.asigs, estAct.rchzs + nvoRchz)
        }
    }
}

fun cumpleReq(sl: Sala, sol: Sol): Boolean {
    return sl.cap >= sol.asis && sol.eqReq.all { req -> sl.eq.contains(req) }
}

fun isDisp(sl: Sala, hr: String, asigs: List<Asig>): Boolean {
    return asigs.none { asig -> asig.idSala == sl.id && asig.hr == hr }
}