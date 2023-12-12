package machine


fun main() {
    val machine = CoffeeMachine()
    machine.run()
}

class CoffeeMachine {
    private val waterPerCup = 200.0
    private val milkPerCup = 50.0
    private val beansPerCup = 15.0
    private var waterAvailable = 0.0
    private var milkAvailable = 0.0
    private var beansAvailable = 0.0
    private var numCoffeeAsRequested = 0
    private var numCoffeeAsPerResource = 0

//    val messageStatus = mapOf(
//        1 to "Starting to make a coffee",
//        2 to "Grinding coffee beans",
//        3 to "Boiling water",
//        4 to "Mixing boiled water with crushed coffee beans",
//        5 to "Pouring coffee into the cup",
//        6 to "Pouring some milk into the cup",
//        7 to "Coffee is ready!"
//        )

    init {
        calculateResource()

        println("Write how many cups of coffee you will need:")
        numCoffeeAsRequested = readln().toInt()

        calculateCoffeeCapacity()
    }

    private fun calculateResource() {
        println("Write how many ml of water the coffee machine has:")
        waterAvailable = readln().toDouble()
        println("Write how many ml of milk the coffee machine has:")
        milkAvailable = readln().toDouble()
        println("Write how many grams of coffee beans the coffee machine has:")
        beansAvailable = readln().toDouble()

        val totalCoffeeBasedOnWater = (waterAvailable / waterPerCup).toInt()
        val totalCoffeeBasedOnMilk = (milkAvailable / milkPerCup).toInt()
        val totalCoffeeBasedOnBeans = (beansAvailable / beansPerCup).toInt()

        numCoffeeAsPerResource = minOf(totalCoffeeBasedOnWater,
            totalCoffeeBasedOnMilk,
            totalCoffeeBasedOnBeans)
    }

    private fun calculateCoffeeCapacity(){
        println("Num. Coffee Requested: $numCoffeeAsRequested")
        println("Num. Coffee Resources: $numCoffeeAsPerResource")

        if(numCoffeeAsRequested > numCoffeeAsPerResource){
            println("No, I can make only $numCoffeeAsPerResource cups of coffee")
        }else if(numCoffeeAsRequested == numCoffeeAsPerResource) {
            println("Yes, I can make that amount of coffee")
        }else{
            val surplus = numCoffeeAsPerResource - numCoffeeAsRequested
            println("Yes I can make that amount of coffee (and even $surplus more than that)")
        }
    }

    fun run(){
        return
    }
}