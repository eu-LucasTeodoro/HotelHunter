package HotelHunter

data class Reserva(val hospede: String, val quarto: Int, val diarias: Int, val total: Double)

fun main () {

    val senha = "2678"

    println("Bem vindo ao Hotel Hunter")
    print("Nome do usuario: ")
    val nome = readln()

    for (i in 1..3) {
        print("Senha: ")
        val senhaInformada = readln()

        if (senhaInformada == senha) {
            println ("Bem-vindo ao Hotel Hunter, $nome")
            println("É um imenso Prazer ter você aqui!")
            inicio(nome)
            break
        } else {
            if (i < 3){
                println("Senha Incorreta!")
                println("Você ainda tem ${3 - i} tentativas")
            }else {
                print("SISTEMA BLOQUEADO.")
            }
        }
    }
}