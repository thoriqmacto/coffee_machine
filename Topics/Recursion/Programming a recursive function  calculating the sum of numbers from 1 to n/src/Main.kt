fun sumRecursive(n: Int): Int {
    // base case / terminal condition here
    if (n == 1 ) return 1

    // recursive call here
    return n + sumRecursive(n-1)
}

fun main() {
    val n = readln().toInt()
    print(sumRecursive(n))
}