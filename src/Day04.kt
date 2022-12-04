fun main() {
    fun part1(input: List<String>): Int {
        var overlap = 0
        input.forEach{ line ->
            val ranges = line.split(",")
            val firstAssignment = ranges[0].split("-").map{it.toInt()}
            val secondAssignment = ranges[1].split("-").map{it.toInt()}

            if (firstAssignment[0] < secondAssignment[0]) {
                if (firstAssignment[1] >= secondAssignment[1]) {
                    overlap += 1
                }
            } else if (firstAssignment[0] == secondAssignment[0]) {
               overlap += 1
            } else if (secondAssignment[1] >= firstAssignment[1]) {
                overlap += 1
            }
        }
        return overlap
    }

    fun part2(input: List<String>): Int {
        var overlap = 0
        input.forEach {line ->
            val ranges = line.split(",","-").map { it.toInt() }
            val firstRange = ranges.subList(0,2)
            val secondRange = ranges.subList(2,4)

            if (firstRange[0] <= secondRange[0] && firstRange[1] >= secondRange[0]) {
                overlap += 1
            } else if (secondRange[0] <= firstRange[0] && secondRange[1] >= firstRange[0]) {
                overlap +=1
            }
        }
        return overlap
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))

}