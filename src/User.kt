//import java.io.FileInputStream
//import kotlin.system.exitProcess
//
//fun readTouristSpots(): List<TouristSpot> {
//    val reader = FileInputStream("resources/touristspots.csv").bufferedReader()
//    reader.readLine() // Reads the first line and skips it since first line is the header
//    return reader.lineSequence()
//        .filter { it.isNotBlank() }
//        .map {
//            val (name, capacity) = it.split(',', ignoreCase = false, limit = 2)
//            TouristSpot(location =  capacity, name = name.trim().removeSurrounding("\""))
//        }.toList()
//}
//
//fun showChoices() {
//    println("""
//        1 - Show/Refresh data
//        2 - Exit Program
//    """.trimIndent())
//}
//
//fun main() {
//    val touristSpots = readTouristSpots()
//    println("Tourist Spot Parking Space Tracker")
//    var choice: Int
//    while (true) {
//        showChoices()
//        try {
//            choice = readln().toInt()
//            when (choice) {
//                1 -> {
//                    for (i in touristSpots) {
//                        i.showDetails()
//                    }
//                    println()
//                }
//                2 -> exitProcess(1)
//                else ->  println("Please enter a valid choice")
//            }
//        } catch (e: NumberFormatException) {
//            println("Please enter a valid choice")
//        }
//    }
//}