import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val box1 = intArrayOf(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
    val box2 = intArrayOf(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())

    box1.sort()
    box2.sort()
//    println(box1.joinToString())
//    println(box2.joinToString())

    val volume1 = box1.reduce { acc, i -> acc * i }
    val volume2 = box2.reduce { acc, i -> acc * i }
    
//    // If the sizes of the boxes are equal, print "Box 1 = Box 2".
//    // If the first box can be put inside the second box, print "Box 1 < Box 2".
//    // If the second box can be put inside the first box, print "Box 1 > Box 2".
//    // If none of the boxes can be put inside another one, print "Incomparable".

    val size = box1.size - 1
    var comparable = true
    if (box1.contentEquals(box2)) {
        print("Box 1 = Box 2")
    } else if (volume1 < volume2) {

        for (i in 0..size) {
            if (box1[i] <= box2[i]) {
                continue
            } else {
                comparable = false
            }
        }
        if (comparable) {
            print("Box 1 < Box 2")
        }
    } else if (volume1 > volume2) {
        for (i in 0..size) {
            if (box1[i] >= box2[i]) {
                continue
            } else {
                comparable = false
            }
        }
        if (comparable) {
            print("Box 1 > Box 2")
        }
    } else {
        print("Incomparable")
    }

    if (!comparable) {
        print("Incomparable")
    }
}
