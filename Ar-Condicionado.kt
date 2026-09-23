package HotelHunter

fun Arcondicionado(nome: String){
    val nomes = mutableListOf<String>()
    val totais = mutableListOf<Double>()

    var continuar = "S"
    while (continuar == "S") {
        print("Nome da empresa: ")
        val empresa = readln()
        print("Valor por aparelho: ")
        val valorAparelho = readln().toDoubleOrNull() ?: 0.0
        print("Quantidade de aparelhos: ")
        val quantidade = readln().toIntOrNull() ?: 0
        print("Desconto (%): ")
        val desconto = readln().toDoubleOrNull() ?: 0.0
        print("Mínimo de desconto: ")
        val minino = readln().toIntOrNull() ?: 0
        print("Deslocamento: ")
        val deslocamento = readln().toDoubleOrNull()  ?: 0.0

        val bruto = valorAparelho * quantidade
        val valorDesconto = if (quantidade >= minino) bruto * (desconto / 100) else 0.0
        val total = bruto - valorDesconto + deslocamento

        println("O serviço de $empresa custará R$ ${"%.2f".format(total)}")

        nomes.add(empresa)
        totais.add(total)

        print("Deseja Informar novos dados, $nome? (S/N): ")
        continuar = readln().uppercase()

    }
    val indiceMenor = totais.indexOf(totais.min())
    println("Melhor orçamento: ${nomes[indiceMenor]} — R$ ${"%.2f".format(totais.min())}")

    val indiceMaior = totais.indexOf(totais.max())
    val diferenca = ((totais.max() - totais.min()) / totais.min()) * 100

    println("Maior orçamento: ${nomes[indiceMaior]} — R$ ${"%.2f".format(totais.max())}")
    println("Diferença percentual entre melhor e pior proposta: ${"%.1f".format(diferenca)}%")
}