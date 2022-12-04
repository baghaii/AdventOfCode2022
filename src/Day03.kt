fun main() {
    fun part1(input: List<String>): Int {
        var totalScore = 0
        input.forEach {
            val firstHalf = it.substring(0, it.length / 2)
            val secondHalf = it.substring(it.length / 2, it.length )

            val inBoth = mutableListOf<Char>()
            firstHalf.forEach { ch ->
                if (secondHalf.contains(ch) && !inBoth.contains(ch)) {
                    inBoth.add(ch)
                }
            }
            val score = inBoth.map { ch ->
                scoreChar(ch)
            }.sum()
            totalScore += score
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        var score = 0
        for(i in 0 .. input.size - 3 step 3) {
            val elf1 = input[i]
            val elf2 = input[i+1]
            val elf3 = input[i+2]

            val badge = elf1.find{ch -> elf2.contains(ch) && elf3.contains(ch)}!!

            score += scoreChar(badge)
        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

fun scoreChar(ch: Char): Int {
    return if (ch in 'a'..'z') {
        ch - 'a' + 1
    } else {
        ch - 'A' + 27
    }
}