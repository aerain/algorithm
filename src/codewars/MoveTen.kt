package codewars

fun main() {
    println(moveTen("testcase"))
}
fun moveTen(s: String): String {
    return s.toCharArray().map {(((it - 'a' + 10) % 26) + 'a'.toInt()).toChar()}.joinToString("")
}