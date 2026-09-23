package HotelHunter

fun CadastrarHospedes(nome: String, hospedes: MutableList<String>){
    var opcao: Int? = null

    while (opcao != 7){
        println("1-Cadastrar 2-Pesquisar 3-Pesquisar prefixo 4-Listar 5-Atualizar 6-Remover 7-Voltar")
        println("Opcao: ")
        opcao = readln().toIntOrNull()

        when (opcao) {
            1 -> {
                if (hospedes.size >=15){
                    println("Máximo de cadastros atingido")
                }else {
                    print("Nome do hóspede: ")
                    val novoNome = readln()
                    if (hospedes.contains(novoNome)){
                        println("Hóspede já cadastrado")
                    }else {
                        hospedes.add(novoNome)
                        println("Hóspede cadastrado com sucesso.")
                    }
                }
            }
            2 -> {
                print("Nome do hóspede a pesquisar: ")
                val busca = readln()
                if (hospedes.contains(busca)){
                    println("Hóspede $busca foi encontrado")
                }else {
                    println("Hóspede não encontrado")
                }
            }
            3 -> {
                print("Prefixo: ")
                val prefixo = readln()
                val resultados = hospedes.filter { it.startsWith(prefixo, ignoreCase = true) }
                if (resultados.isEmpty()) {
                    println("Nenhum hóspede encontrado com esse prefixo.")
                } else {
                    println("Resultados:")
                    for (i in resultados.indices) {
                        println("[${i + 1}] ${resultados[i]}")
                    }
                }
            }
            4 -> {
                if (hospedes.isEmpty()){
                    println("Nenhum hóspede cadastrado.")
                }else {
                    val ordenados = hospedes.sorted()
                    for (i in ordenados.indices){
                        println ("[${i + 1}]: ${ordenados[i]}")
                    }
                }
            }
            5 -> {
                if (hospedes.isEmpty()) {
                    println("Nenhum hóspede cadastrado.")
                } else {
                    val ordenados = hospedes.sorted()
                    for (i in ordenados.indices) {
                        println("[${i + 1}] ${ordenados[i]}")
                    }
                    print("Número do hóspede a atualizar: ")
                    val indice = readln().toIntOrNull()
                    if (indice == null || indice < 1 || indice > ordenados.size) {
                        println("Índice inválido.")
                    } else {
                        val nomeAntigo = ordenados[indice - 1]
                        print("Novo nome: ")
                        val nomeNovo = readln()
                        val posicaoReal = hospedes.indexOf(nomeAntigo)
                        hospedes[posicaoReal] = nomeNovo
                        println("Operação realizada com sucesso")
                    }
                }
            }
            6 -> {
                if (hospedes.isEmpty()) {
                    println("Nenhum hóspede cadastrado.")
                } else {
                    val ordenados = hospedes.sorted()
                    for (i in ordenados.indices) {
                        println("[${i + 1}] ${ordenados[i]}")
                    }
                    print("Número do hóspede a remover: ")
                    val indice = readln().toIntOrNull()
                    if (indice == null || indice < 1 || indice > ordenados.size) {
                        println("Índice inválido.")
                    } else {
                        val nomeRemover = ordenados[indice - 1]
                        hospedes.remove(nomeRemover)
                        println("Operação realizada com sucesso")
                    }
                }
            }
            7 -> println("Voltando ao menu principal...")
            else -> println("Opção inválida!")
        }
    }
}