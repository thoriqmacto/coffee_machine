package machine

fun main() {
    val totalCups = readln().toInt()
    val machine = CoffeeMachine(totalCups)
}

class CoffeeMachine(val totalCups:Int) {
    private val waterPerCup = 200
    private val milkPerCup = 50
    private val beansPerCup = 15

    val messageStatus = mapOf(
        1 to "Starting to make a coffee",
        2 to "Grinding coffee beans",
        3 to "Boiling water",
        4 to "Mixing boiled water with crushed coffee beans",
        5 to "Pouring coffee into the cup",
        6 to "Pouring some milk into the cup",
        7 to "Coffee is ready!"
        )

    init {
        calculateIngredients()
    }

    private fun calculateIngredients(){
        val waterNeeded = totalCups * waterPerCup
        val milkNeeded = totalCups * milkPerCup
        val beansNeeded = totalCups * beansPerCup

        println("For $totalCups cups of coffee you will need:")
        println("$waterNeeded ml of water")
        println("$milkNeeded ml of milk")
        println("$beansNeeded g of coffee beans")
    }
}