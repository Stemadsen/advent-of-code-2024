package `01`.`2`

import readFileColumns

fun main() {
    val startTime = System.currentTimeMillis()
    println("Answer: $answer")
    println("Execution time: ${System.currentTimeMillis() - startTime} ms")
}

val lists = readFileColumns("01/input.txt", Regex("\\s+"))
    .map { it.map { it.toLong() } }
    .map { it.sorted() }

val numberOccurrencesInSecondList = lists[0].distinct().associateWith { number -> lists[1].count { it == number } }
val similarityScores = numberOccurrencesInSecondList.mapValues { (number, occurrences) -> number * occurrences }
val answer = lists[0].sumOf { similarityScores[it]!!.toLong() }
