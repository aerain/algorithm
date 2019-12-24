package codewars.kotlin

fun makeComplement(dna : String) : String = dna.toCharArray().map { when(it) {
    'A' -> 'T'
    'T' -> 'A'
    'G' -> 'C'
    'C' -> 'G'
    else -> ' '
} }.joinToString("")

fun main() {
    println(makeComplement("AAAA"))
}