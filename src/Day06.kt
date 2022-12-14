fun main() {
    fun part1(input: List<String>): Int {
        input[0].windowed(4,1).forEachIndexed{ i, it ->
            if ( it.toCharArray().distinct().size == 4 ) {
                return i + 4
            }
        }

        return 0
    }

    fun part2(input: List<String>): Int {
        input[0].windowed(14,1).forEachIndexed{ i, it ->
            if ( it.toCharArray().distinct().size == 14 ) {
                return i + 14
            }
        }

        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 23)
    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}