package machine


fun main() {
    val machine = CoffeeMachine()
    machine.run()
}

class CoffeeMachine {
    private var amountOfWater:Int = 400
    private var amountOfMilk:Int = 540
    private var amountOfBeans:Int = 120
    private var amountOfCups:Int = 9
    private var amountOfMoney:Int = 550

    private var actionState:String = ""
    private var buyChoice = 0
    private var fillWater= 0
    private var fillMilk = 0
    private var fillBeans = 0
    private var fillCups = 0

    private val ingredientsEspresso = mapOf(
        "water" to 250,
        "milk" to 0,
        "beans" to 16,
        "price" to 4
    )
    private val ingredientsLatte = mapOf(
        "water" to 350,
        "milk" to 75,
        "beans" to 20,
        "price" to 7
    )

    private val ingredientsCappucino = mapOf(
        "water" to 200,
        "milk" to 100,
        "beans" to 12,
        "price" to 6
    )

//    private var waterAvailable = 0.0
//    private var milkAvailable = 0.0
//    private var beansAvailable = 0.0
//    private var numCoffeeAsRequested = 0
//    private var numCoffeeAsPerResource = 0

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
        printMachineState()
    }

    private fun printMachineState() {
        println("The coffee machine has:")
        println("$amountOfWater ml of water")
        println("$amountOfMilk ml of milk")
        println("$amountOfBeans g of coffee beans")
        println("$amountOfCups disposable cups")
        println("\$$amountOfMoney of money")
        println()
    }

    private fun promptUser(){
        println("Write action (buy, fill, take):")
        val userChoice = readln()

        when(userChoice) {
            "buy" -> {
                actionState = "buy"
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
                buyChoice = readln().toInt()
            }
            "fill" -> {
                actionState = "fill"
                println("Write how many ml of water you want to add:")
                fillWater = readln().toInt()
                println("Write how many ml of milk you want to add:")
                fillMilk = readln().toInt()
                println("Write how many grams of coffee beans you want to add:")
                fillBeans = readln().toInt()
                println("Write how many disposable cups you want to add:")
                fillCups = readln().toInt()
            }
            "take" -> {
                actionState = "take"
            }
        }
    }

    private fun updateResource(resourceType:String) {
        when(resourceType){
            "buy" -> {
                when(buyChoice){
                    1 -> {
                        ingredientsEspresso.forEach { (k,v) ->
                            when(k){
                                "water" -> amountOfWater = amountOfWater.minus(v)
                                "beans" -> amountOfBeans = amountOfBeans.minus(v)
                                "price" -> amountOfMoney += v
                            }
                        }
                    }
                    2 -> {
                        ingredientsLatte.forEach { (k,v) ->
                            when(k){
                                "water" -> amountOfWater = amountOfWater.minus(v)
                                "beans" -> amountOfBeans = amountOfBeans.minus(v)
                                "price" -> amountOfMoney += v
                                "milk" -> amountOfMilk = amountOfMilk.minus(v)
                            }
                        }
                    }
                    3 -> {
                        ingredientsCappucino.forEach { (k,v) ->
                            when(k){
                                "water" -> amountOfWater = amountOfWater.minus(v)
                                "beans" -> amountOfBeans = amountOfBeans.minus(v)
                                "price" -> amountOfMoney += v
                                "milk" -> amountOfMilk = amountOfMilk.minus(v)
                            }
                        }
                    }
                }
                amountOfCups--
            }
            "fill" -> {
                amountOfWater += fillWater
                amountOfMilk += fillMilk
                amountOfBeans += fillBeans
                amountOfCups += fillCups
            }
            "take" -> {
                println("I gave you \$$amountOfMoney")
                amountOfMoney = 0
            }
        }

//        val totalCoffeeBasedOnWater = (waterAvailable / waterPerCup).toInt()
//        val totalCoffeeBasedOnMilk = (milkAvailable / milkPerCup).toInt()
//        val totalCoffeeBasedOnBeans = (beansAvailable / beansPerCup).toInt()
//
//        numCoffeeAsPerResource = minOf(totalCoffeeBasedOnWater,
//            totalCoffeeBasedOnMilk,
//            totalCoffeeBasedOnBeans)
    }

//    private fun calculateCoffeeCapacity(){
//        println("Num. Coffee Requested: $numCoffeeAsRequested")
//        println("Num. Coffee Resources: $numCoffeeAsPerResource")
//
//        if(numCoffeeAsRequested > numCoffeeAsPerResource){
//            println("No, I can make only $numCoffeeAsPerResource cups of coffee")
//        }else if(numCoffeeAsRequested == numCoffeeAsPerResource) {
//            println("Yes, I can make that amount of coffee")
//        }else{
//            val surplus = numCoffeeAsPerResource - numCoffeeAsRequested
//            println("Yes I can make that amount of coffee (and even $surplus more than that)")
//        }
//    }

    fun run(){
        promptUser()
        updateResource(actionState)
        printMachineState()
    }
}