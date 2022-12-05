import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    fun part1(input: List<String>, stacks: List<Stack<Char>>): String {
        input.forEach {
            val tokens = it.split(' ')
            val howMany = tokens[1].toInt()
            val fromStack = tokens[3].toInt() - 1
            val toStack = tokens[5].toInt() - 1
            for (i in 0 until howMany) {
                val char = stacks[fromStack].pop()
                stacks[toStack].push(char)
            }
        }

        val word = String(stacks.map{ it.pop() }.toCharArray())
        return word
    }

    fun part2(input: List<String>, stacks: List<Stack<Char>>): String {
        input.forEach {
            val tokens = it.split(' ')
            val howMany = tokens[1].toInt()
            val fromStack = tokens[3].toInt() - 1
            val toStack = tokens[5].toInt() - 1
            val tempStack = Stack<Char>()
            for (i in 0 until howMany) {
                val char = stacks[fromStack].pop()
                tempStack.push(char)
            }
            while (tempStack.isNotEmpty()) {
                val charToMove = tempStack.pop()
                stacks[toStack].push(charToMove)
            }
        }

        val word = String(stacks.map{ it.pop() }.toCharArray())
        return word
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput, buildTestStack()) == "CMZ")
    check(part2(testInput, buildTestStack()) == "MCD")

    val input = readInput("Day05")
    println(part1(input, buildStack()))
    println(part2(input, buildStack()))
}

fun buildTestStack(): List<Stack<Char>> {
    val stack1 = Stack<Char>()
    stack1.push('Z')
    stack1.push('N')

    val stack2 = Stack<Char>()
    stack2.push('M')
    stack2.push('C')
    stack2.push('D')

    val stack3 = Stack<Char>()
    stack3.push('P')

    return listOf(stack1, stack2, stack3)
}

fun buildStack(): List<Stack<Char>> {
    val stack1 = Stack<Char>()
    stack1.push('L')
    stack1.push('N')
    stack1.push('W')
    stack1.push('T')
    stack1.push('D')

    val stack2 = Stack<Char>()
    stack2.push('C')
    stack2.push('P')
    stack2.push('H')

    val stack3 = Stack<Char>()
    stack3.push('W')
    stack3.push('P')
    stack3.push('H')
    stack3.push('N')
    stack3.push('D')
    stack3.push('G')
    stack3.push('M')
    stack3.push('J')

    val stack4 = Stack<Char>()
    stack4.push('C')
    stack4.push('W')
    stack4.push('S')
    stack4.push('N')
    stack4.push('T')
    stack4.push('Q')
    stack4.push('L')

    val stack5 = Stack<Char>()
    stack5.push('P')
    stack5.push('H')
    stack5.push('C')
    stack5.push('N')

    val stack6 = Stack<Char>()
    stack6.push('T')
    stack6.push('H')
    stack6.push('N')
    stack6.push('D')
    stack6.push('M')
    stack6.push('W')
    stack6.push('Q')
    stack6.push('B')

    val stack7 = Stack<Char>()
    stack7.push('M')
    stack7.push('B')
    stack7.push('R')
    stack7.push('J')
    stack7.push('G')
    stack7.push('S')
    stack7.push('L')

    val stack8 = Stack<Char>()
    stack8.push('Z')
    stack8.push('N')
    stack8.push('W')
    stack8.push('G')
    stack8.push('V')
    stack8.push('B')
    stack8.push('R')
    stack8.push('T')

    val stack9 = Stack<Char>()
    stack9.push('W')
    stack9.push('G')
    stack9.push('D')
    stack9.push('N')
    stack9.push('P')
    stack9.push('L')

    return(listOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9))
}
