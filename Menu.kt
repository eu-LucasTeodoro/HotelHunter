package HotelHunter

fun inicio(nome: String){
    var escolha: Int? = null
    val quartos = BooleanArray(20)
    val historico = mutableListOf<Reserva>()
    val hospedes = mutableListOf<String>()
    var totalEventosConfirmados = 0
    var receitaEventos = 0.0

    while (escolha != 7){
        println("===============HOTEL HUNTER===============")
        println("1 - Reserva de Quartos")
        println("2 - Cadastro de Hóspedes")
        println("3 - Eventos")
        println("4 - Ar-Condicionado")
        println("5 - Abastecimento")
        println("6 - Relatorios")
        println("7 - sair")

        println("Escolha uma opção: ")
        escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> CadastrarQuartos(nome, quartos, historico  )
            2 -> CadastrarHospedes(nome, hospedes)
            3 -> {
                val resultado = Eventos(nome)
                if (resultado > 0) {
                    totalEventosConfirmados++
                    receitaEventos += resultado
                }
            }
            4 -> Arcondicionado(nome)
            5 -> Abastecimento(nome)
            6 -> Relatorios(quartos, historico, hospedes, totalEventosConfirmados, receitaEventos)
            7 -> SairDoHotel(nome)
            else -> erro()
        }
    }
}