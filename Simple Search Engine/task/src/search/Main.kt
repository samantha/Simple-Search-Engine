package search
import java.io.File

fun displayMenu() {
    println("1. Search information.")
    println("2. Print all data.")
    println("0. Exit.")
}

fun findPerson(data: List<String>, invertedIndex: MutableMap<String, MutableList<Int>>) {
    // select a matching strategy
    val strategy = readLine()!!
    val target = readLine()!!
    val targetWords: List<String> = target.split(" ")
    val targetIndices = filterWords(invertedIndex, targetWords)
    when (strategy) {
        "ANY" -> findAny(invertedIndex, data, targetIndices)
        "ALL" -> findAll(invertedIndex, data, targetIndices, targetWords)
        "NONE" -> findNone(invertedIndex, data, targetIndices)
    }
}

fun findAny(invertedIndex: MutableMap<String, MutableList<Int>>, data: List<String>, targetIndices: Set<Int>) {
    for (index in data.indices) {
        if (index in targetIndices) {
            println(data[index])
        }
    }
}

fun findAll(invertedIndex: MutableMap<String, MutableList<Int>>, data: List<String>, targetIndices: Set<Int>, targetWords: List<String>) {
    for (index in data.indices) {
        if (index in targetIndices) {
            // check if all target words are in a line
            var flag = true
            for (target in targetWords) {
                if (target !in data[index]) {
                    flag = false
                }
            }

            if (flag) {
                println(data[index])
            }
        }
    }
}

fun findNone(invertedIndex: MutableMap<String, MutableList<Int>>, data: List<String>, targetIndices: Set<Int>) {
    for (index in data.indices) {
        if (index !in targetIndices) {
            println(data[index])
        }
    }
}

fun filterWords(invertedIndex: MutableMap<String, MutableList<Int>>, targetWords: List<String>): Set<Int> {
    var targetIndices: MutableSet<Int> = mutableSetOf()
    for (target in targetWords) {
        if (target in invertedIndex) {
            val indices = invertedIndex[target.toLowerCase()]!!
            for (index in indices) {
                targetIndices.add(index)
            }
        }
    }

    return targetIndices
}

fun printPeople(data: List<String>) {
    for (person in data) {
        println(person)
    }
}

fun main(args: Array<String>) {
    // Enter all people:
    val data: MutableList<String> = mutableListOf()
    val invertedIndex: MutableMap<String, MutableList<Int>> = mutableMapOf<String, MutableList<Int>>()
    val file = File(args[1])
    file.forEachLine {
        line:String -> data.add(line)
    }

    for (index in 0 until data.size) {
        println(index)
        val info = data[index]
        val words = info.split(" ")
        for (word in words) {
            println(word)
            invertedIndex.getOrPut(word.toLowerCase(), ::mutableListOf) += index
        }
    }

    displayMenu()

    var menuOption: Int = readLine()!!.toInt()

    do {
        when (menuOption) {
            1 -> findPerson(data, invertedIndex)
            2 -> printPeople(data)
            0 -> println("Bye!")
            else -> println("Incorrect option! Try again.")
        }
        if (menuOption != 0) {
            menuOption = readLine()!!.toInt()
        }
    } while(menuOption != 0)
}


