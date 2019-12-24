package codewars.kotlin

fun findMissingLetter(array: CharArray): Char {
    var temp = array[0]
    for(ch in array) {
        if(ch - temp > 1) return ch - 1
        temp = ch
    }
    return ' '
}