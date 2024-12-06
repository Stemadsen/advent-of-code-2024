fun readFileLines(path: String): List<String> =
    object {}::class.java.getResource(path)!!.readText().lines()
        .dropWhile { it.isEmpty() }
        .dropLastWhile { it.isEmpty() }

fun readFileColumns(path: String, separator: Regex): List<List<String>> {
    val lines = readFileLines(path)
    val numColumns = lines.first().split(separator).size
    val columns = List(numColumns) { mutableListOf<String>() }
    lines.forEach { line ->
        line.split(separator).forEachIndexed { index, column ->
            columns[index].add(column)
        }
    }
    return columns
}
