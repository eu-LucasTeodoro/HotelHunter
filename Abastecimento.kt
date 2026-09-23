package HotelHunter

fun Abastecimento(nome: String){
    print("Wayne oiL - Preço do álcool: ")
    val alcoolWayne = readln().replace(",",".").toDoubleOrNull() ?: 0.0
    print("Wayne oiL - Preço da gasolina: ")
    val gasolinaWayne = readln().replace(",",".").toDoubleOrNull() ?: 0.0

    print("Stark Petrol - Preço do alcool: ")
    val alcoolStark = readln().replace(" ,",".").toDoubleOrNull() ?: 0.0
    print("Stark Petrol - Preço da gasolina: ")
    val gasolinaStark = readln().replace(" ,",".").toDoubleOrNull() ?: 0.0

    val custoWayne = if (alcoolWayne <= gasolinaWayne * 0.70) alcoolWayne * 42 else gasolinaWayne * 42
    val melhorWayne = if (alcoolWayne <= gasolinaWayne * 0.70) "Álcool" else "Gasolina"

    val custoStark = if (alcoolStark <= gasolinaStark * 0.70) alcoolStark * 42 else gasolinaStark * 42
    val melhorStark = if (alcoolStark <= gasolinaStark * 0.70) "Álcool" else "Gasolina"


    println("Wayne Oil: melhor opção = $melhorWayne | Total (42L) = R$ ${"%.2f".format(custoWayne)} ")
    println("Stark Petrol: Melhor opção = $melhorStark | Total (42) = R$ ${"%.2f".format(custoStark)} ")

    if (custoWayne <= custoStark){
        println("$nome, é mais barato abastecer com $melhorWayne no posto Wayne Oil.")
    }else {
        println("$nome, é mais barato abastecer com $melhorStark no posto Stark Petrol.")
    }
}