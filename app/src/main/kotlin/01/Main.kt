package `01`

import readFileColumns
import kotlin.math.abs

fun main() {
    val startTime = System.currentTimeMillis()
    println("Answer: $answer")
    println("Execution time: ${System.currentTimeMillis() - startTime} ms")
}

val lists = readFileColumns("01/input.txt", Regex("\\s+"))
    .map { it.map { it.toLong() } }
    .map { it.sorted() }

val answer = (0..<lists[0].size).sumOf { i ->
    abs(lists[1][i] - lists[0][i])
}
