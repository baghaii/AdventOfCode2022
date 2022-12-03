fun main() {
    fun part1(input: List<String>): Int {
        val calories = mutableListOf<Int>()
        var calorieCount = 0
        var maxCalories = 0
        input.forEach {
            if (it.isNotEmpty()) {
                calorieCount += it.toInt()
            } else {
                if (calorieCount > maxCalories) {
                    maxCalories = calorieCount
                }
                calories.add(calorieCount)
                calorieCount = 0
            }
        }
        return maxCalories
    }

    fun part2(input: List<String>): Int {
        val calories = mutableListOf<Int>()
        var calorieCount = 0
        var maxCalories = 0
        input.forEach {
            if (it.isNotEmpty()) {
                calorieCount += it.toInt()
            } else {
                if (calorieCount > maxCalories) {
                    maxCalories = calorieCount
                }
                calories.add(calorieCount)
                calorieCount = 0
            }
        }
        calories.sortDescending()
        return calories.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01")
    check(part1(testInput) == 70296)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
