import kotlin.system.exitProcess

var setOfTouristSpots = giveSetOfTouristSpots()
var setOfRestaurants = giveSetOfRestaurants()
fun startingChoice() {
    var go = true
    println("""
        What to do?
        1 - Log in as admin
        2 - Log in as guest
        
        3 - Exit program
    """.trimIndent())
    try {
        var choice: Int
        do {
            choice = readln().toInt()
            when (choice) {
                1 -> {
                    logInAsOwner()
                    go = false
                }
                2 -> {
                    logInAsGuest()
                    go = false
                }
                3 -> {
                    println("Have a good day")
                    exitProcess(1)
                }
                else -> {
                    println("Please enter a valid choice")
                }
            }
        } while (go)
    } catch (nfe: NumberFormatException) {
        println("Please enter a number")
    }
}

fun logInAsGuest(){
    var choice = 0
    do {
        println("""
            What to do?
            1 - View tourist spot details
            2 - View restaurant details
        
            3 - Log Out
        """.trimIndent())
        try {
            choice = readln().toInt()
            when (choice) {
                1 -> {
                    viewTouristSpotsDetails(setOfTouristSpots)
                }
                2 -> {
                    viewRestaurantsDetails(setOfRestaurants)
                }
                3 -> {
                    startingChoice()
                }
                else -> {
                    println("Please enter a valid choice")
                }
            }
        }catch (nfe: NumberFormatException) {
            println("Please enter a number")
        }
    } while (choice != 0)
}

fun logInAsOwner() {
    var logInName: String
    var logInPassword: String
    var checker = true
    do {
        println("Username: ")
        logInName = readln()
        println("Password: ")
        logInPassword = readln()
        if (logInName == "haydee") {
            if (logInPassword == "password123") {
                checker = false
                println("Welcome $logInName!")
            } else println("Incorrect password")
        } else println("User not found")
        if (checker) {println("User not found")}
    } while (checker)
    ownerCRUD()
}

fun viewTouristSpotsDetails(set: MutableSet<TouristSpots>) {
    var num = 1
    for (i in set) {
        println("Tourist Spot # $num")
        i.showDetails()
        println()
        num += 1
    }
}

fun viewRestaurantsDetails(set: MutableSet<Restaurant>) {
    var num = 1
    for (i in set) {
        println("Restaurant #$num")
        i.showDetails()
        println()
        num += 1
    }
}

fun ownerCRUD() {
    var choice = 0
    do {
        printOwnerCRUDChoices()
        try {
            choice = readln().toInt()
            when (choice) {
                1 -> {viewTouristSpotsDetails(setOfTouristSpots)}
                2 -> {viewRestaurantsDetails(setOfRestaurants)}
                3 -> {println("Edit vacancies")}
                4 -> {println("Edit vacancies")}
                5 -> {
                    setOfTouristSpots.add(addTouristSpot())
                    ownerCRUD()
                }
                6-> {
                    setOfRestaurants.add(addRestaurant())
                    ownerCRUD()
                }
                7 -> {
                    viewTouristSpotsDetails(setOfTouristSpots)
                    ownerCRUD()
                }
                8 -> {
                    viewRestaurantsDetails(setOfRestaurants)
                    ownerCRUD()
                }
                9 -> {
                    startingChoice()
                }
                else -> {
                    println("Please enter a valid choice")
                }
            }
        } catch (nfe: NumberFormatException) {println("Please enter a number")}
    } while (choice != 0)
}

fun main() {
    startingChoice()
}