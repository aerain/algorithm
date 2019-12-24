package codewars.kotlin

fun Kata(word: String) = if(word.length % 2 == 0) word.substring(word.length / 2 - 1, word.length / 2 + 1) else word.substring(word.length / 2, word.length / 2 + 1)

fun main() {
    println(Kata("test"))
    println(Kata("middle"))
    println(Kata("testing"))
    println(Kata("A"))
}

