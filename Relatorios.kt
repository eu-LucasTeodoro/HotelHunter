package HotelHunter

fun Relatorios(quartos: BooleanArray, historico: MutableList<Reserva>, hospedes: MutableList<String>, totalEventos: Int, receitaEventos: Double) {
    val ocupados = quartos.count { it == true }
    val taxaOcupacao = (ocupados.toDouble() / 20) * 100
    val receitaHospedagem = historico.sumOf { it.total }
    val receitaTotal = receitaHospedagem + receitaEventos

    println("========== RELATÓRIOS OPERACIONAIS ==========")
    println("Total de reservas confirmadas: ${historico.size}")
    println("Taxa de ocupação: ${"%.1f".format(taxaOcupacao)}%")
    println("Hóspedes cadastrados: ${hospedes.size}")
    println("Eventos confirmados: $totalEventos")
    println("Receita hospedagem: R$ ${"%.2f".format(receitaHospedagem)}")
    println("Receita eventos: R$ ${"%.2f".format(receitaEventos)}")
    println("Receita total: R$ ${"%.2f".format(receitaTotal)}")
}
