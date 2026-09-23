package HotelHunter

import kotlin.math.ceil
import kotlin.math.floor


fun Eventos(nome: String): Double {
    print("Convidados: ")
    val convidados = readln().toIntOrNull()
    if (convidados == null || convidados < 0 || convidados > 350) {
        println("Número de convidados inválido")
        return 0.0
    }

    if (convidados <= 150) {
        println("Auditorio selecionado: Laranja")
    } else if (convidados <= 230) {
        val extras = convidados - 150
        println("Auditorio selecionado: Laranja ($extras cadeiras adicionais)")
    } else {
        println("Auditorio selecionado: Colorado")
    }

    print("Dia: ")
    val dia = readln()
    print("Hora inicial: ")
    val horaInicial = readln().toIntOrNull()
    print("Duração: ")
    val duracao = readln().toIntOrNull()

    if (horaInicial == null || duracao == null || duracao < 1 || duracao > 12) {
        println("Dados inválidos")
        return 0.0
    }
    val fechamento = when (dia) {
        "sabado", "domingo" -> 15
        else -> 23
    }

    val horaFinal = horaInicial + duracao

    if (horaInicial < 7 || horaFinal > fechamento) {
        println("Auditorio indisponivel nesse horário.")
        return 0.0
    }

    print("Empresa: ")
    val empresa = readln()
    println("Auditorio reservado para $empresa: $dia às ${horaInicial}hs ")

    val base = ceil(convidados / 12.0).toInt()
    val reforco = floor(duracao / 2.0).toInt()
    val totalGarcons = base + reforco
    val custoGarcons = totalGarcons * duracao * 10.50

    println("Garçons necesários: $totalGarcons")
    println("Custo com garçons: ${"%.2f".format(custoGarcons)}")

    val cafeLitros = convidados * 0.2
    val aguaLitros = convidados * 0.5
    val salgadosQtd = convidados * 7

    val custoCafe = cafeLitros * 0.80
    val custoAgua = aguaLitros * 0.40
    val custoSalgados = salgadosQtd * (34.00 / 100)

    val custoBuffet = custoCafe + custoAgua + custoSalgados

    println("Buffet: ")
    println("Cafe: ${"%.2f".format(cafeLitros)} L")
    println("Água: ${"%.2f".format(aguaLitros)} L")
    println("Salgados: $salgadosQtd un")
    println("Custo buffet: R$ ${"%.2f".format(custoBuffet)}")

    val totalEventos = custoGarcons + custoBuffet

    println("Total do evento: R$ ${"%.2f".format(totalEventos)}")
    print("Confirmar reserva? (S/N): ")
    val confirmaEvento = readln().uppercase()

    if (confirmaEvento == "S") {
        println("Reserva efetuada com sucesso. ")
        return totalEventos
    } else {
        println("Reserva não efetuada.")
        return 0.0
    }
}