package HotelHunter

fun CadastrarQuartos(nome: String, quartos: BooleanArray, historico: MutableList<Reserva>) {
    print("Informe o valor da diaria: ")
    val valor = readln().toDoubleOrNull()
    if (valor == null || valor <= 0) {
        println("Valor inválido, $nome")
        return
    }
    print("Informe quantas diárias (1-30): ")
    val diaria = readln().toIntOrNull()
    if (diaria == null || diaria < 1 || diaria > 30) {
        println("Valor inválido, $nome")
        return
    }
    print("Informe o nome completo do hóspede: ")
    val hospede = readln()

    print("Tipo de quarto (S/E/L): ")
    val tipo = readln().uppercase().firstOrNull()

    val fator = when (tipo) {
        'S' -> 1.00
        'E' -> 1.35
        'L' -> 1.65
        else -> null
    }
    if (fator == null) {
        print("Tipo invalido, $nome")
        return
    }
    print("Escolha um quarto (1 a 20): ")
    var quarto = readln().toIntOrNull()
    while (quarto == null || quarto < 1 || quarto > 20 || quartos[quarto - 1] == true) {
        if (quarto != null && quarto in 1..20 && quartos[quarto - 1] == true) {
            println("Quarto já está ocupado.")
            var livres = "Quartos livres: "
            for (n in 1..20){
                if (quartos[n  -1] == false){
                    livres += "$n "
                }
            }
            println("$livres")
        } else {
            println("Valor inválido, $nome")
        }
        print("Escolha outro quarto: ")
        quarto = readln().toIntOrNull()
    }

    val subTotal = diaria * valor * fator
    val taxa = subTotal * 0.10
    val total = subTotal + taxa
    println("Subtotal: R$ ${"%.2f".format(subTotal)}")
    println("Taxa de serviço (10%): R$ ${"%.2f".format(taxa)}")
    println("Total: R$ ${"%.2f".format(total)}")

    println("$nome, confirma a reserva? (S/N)> ")
    val confirma = readln().uppercase()
    if (confirma == "S") {
        quartos[quarto - 1] = true
        historico.add(Reserva(hospede, quarto, diaria, total))
        println(message = "Reserva efetuada com sucesso.")

        println("========== MAPA DE QUARTOS ==========")
        for (n in 1..20){
            if (quartos[n  -1] == true){
                print("$n-O ")
            }else {
                print("$n-L ")
            }
            if (n % 5 == 0){
                println()
            }
        }
    }else {
        println("Reserva não efetuada.")
    }
}