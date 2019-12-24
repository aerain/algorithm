package codewars.kotlin

object PlayPass {
    fun playPass(s: String, n: Int): String = s.toCharArray().map { if(it < 'A' || it > 'z') it else ' '}.reversed().joinToString ("")
}

fun main() {
    println(PlayPass.playPass(" I LOVE YOU!!!", 1))
}