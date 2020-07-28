import java.util.Scanner
fun main() {
    val words = mutableMapOf<String, Int>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val word = scanner.next()
        if (word != "stop") {
            words[word] = words.getOrDefault(word, 1) + 1
        }
    }
    
    var maxVal = Int.MIN_VALUE
    var maxWord = ""
    
    for ((word, freq) in words) {
        if (freq > maxVal) {
            maxVal = freq
            maxWord = word
        }
    }
    
    if (maxWord != "") print(maxWord) else print("null")
}
