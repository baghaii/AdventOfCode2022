fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach{
            val their = it[0]
            val our = it[2]

            val score = scoreRound(their, our)
            sum += score
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val their = it[0]
            val our = it[2]

            val score = pickOurs(their, our)
            sum += score
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

enum class Outcome {
    WIN,
    LOSE,
    TIE
}

// Part 1 Functions
fun scoreRound(their: Char, our: Char): Int {
    val win = when {
        (their == 'A' && our == 'X') -> Outcome.TIE
        (their == 'A' && our == 'Y') -> Outcome.WIN
        (their == 'A' && our == 'Z') -> Outcome.LOSE
        (their == 'B' && our == 'X') -> Outcome.LOSE
        (their == 'B' && our == 'Y') -> Outcome.TIE
        (their == 'B' && our == 'Z') -> Outcome.WIN
        (their == 'C' && our == 'X') -> Outcome.WIN
        (their == 'C' && our == 'Y') -> Outcome.LOSE
        (their == 'C' && our == 'Z') -> Outcome.TIE
        else -> Outcome.TIE
    }

    val matchScore = when (win) {
        Outcome.WIN -> 6
        Outcome.TIE -> 3
        Outcome.LOSE -> 0
    }

    val selectionScore = when(our) {
        'X' -> 1
        'Y' -> 2
        'Z' -> 3
        else -> 0
    }

    return matchScore + selectionScore
}

// Part 2 Functions
fun pickOurs(their: Char, our: Char): Int {
    val outcome = when (our) {
        'X' -> Outcome.LOSE
        'Y' -> Outcome.TIE
        'Z' -> Outcome.WIN
        else -> Outcome.TIE
    }

    val matchScore = when (outcome) {
        Outcome.WIN -> 6
        Outcome.TIE -> 3
        Outcome.LOSE -> 0
    }

    val ourSelection = ourChoice(their, outcome)
    val selectionScore = when(ourSelection) {
        'X' -> 1
        'Y' -> 2
        'Z' -> 3
        else -> 0
    }

    return matchScore + selectionScore
}

fun ourChoice(their: Char, outcome: Outcome): Char {
    return when {
        (their == 'A' && outcome == Outcome.WIN) -> 'Y'
        (their == 'A' && outcome == Outcome.TIE) -> 'X'
        (their == 'A' && outcome == Outcome.LOSE) -> 'Z'
        (their == 'B' && outcome == Outcome.WIN) -> 'Z'
        (their == 'B' && outcome == Outcome.TIE) -> 'Y'
        (their == 'B' && outcome == Outcome.LOSE) -> 'X'
        (their == 'C' && outcome == Outcome.WIN) -> 'X'
        (their == 'C' && outcome == Outcome.TIE) -> 'Z'
        (their == 'C' && outcome == Outcome.LOSE) -> 'Y'
        else -> 'X'
    }
}