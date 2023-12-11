package machine

fun main() {
    val machine = CoffeeMachine()
    machine.messageStatus.forEach { (_, v) ->
        println(v)
    }
}

class CoffeeMachine {
    val messageStatus = mapOf(
        1 to "Starting to make a coffee",
        2 to "Grinding coffee beans",
        3 to "Boiling water",
        4 to "Mixing boiled water with crushed coffee beans",
        5 to "Pouring coffee into the cup",
        6 to "Pouring some milk into the cup",
        7 to "Coffee is ready!"
        )
}