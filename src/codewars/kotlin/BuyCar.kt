package codewars.kotlin

object BuyCar {
    fun nbMonths(
            startPriceOld: Int,
            startPriceNew: Int,
            savingperMonth: Int,
            percentLossByMonth: Double
    ): Pair<Int, Int> {
        // your code
        var startOld : Double = startPriceOld.toDouble()
        var startNew : Double = startPriceNew.toDouble()
        var month = 1
        while (startOld + month * savingperMonth < startNew) {
            val percentage = (percentLossByMonth + (month / 2) * 0.5) * 0.01
            println("${percentage * 100}%")
            startOld = startOld * (1 - percentage)
            startNew *= (1 - percentage)
            println("${startOld + month * savingperMonth - startNew}")
            month++
        }

        val percentage = (percentLossByMonth + (month / 2) * 0.5) * 0.01
        startOld = startOld * (1 - percentage)
        startNew *= (1 - percentage)

        return Pair(month, (startOld + month * savingperMonth - startNew).toInt())
    }
}

fun main() {
    println(BuyCar.nbMonths(2000, 8000, 1000, 1.5))
}