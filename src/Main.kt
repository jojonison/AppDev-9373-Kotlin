
val user = User("Jonison", "123")
var setOfTouristSpots = giveSetOfTouristSpots()
var setOfRestaurants = giveSetOfRestaurants()
fun login() {
    var go = true
    while (go) {
        printLoginChoices()
        when (readLine()?.toIntOrNull()) {
            1 -> {
                val authResult = authenticateUser(user)
                when (authResult) {
                    is AuthenticationResult.Success -> {
                    logInAsOwner()
                    }
                    AuthenticationResult.Failure -> println("Username or Password is incorrect. Please try again!")
                    AuthenticationResult.AccountLockout -> println("Your account is temporarily locked due to too many failed login attempts.")
                }
            }
            2 -> {
                logInAsGuest()
            }
            3 -> {
                println("Thank you and have a good day!")
                go = false
            }
            else -> {
                println("Invalid option. Please try again.")
            }
        }
    }
}
fun authenticateUser(user: User): AuthenticationResult {
    println("Enter login details!")
    print("Username: ")
    val inputUsername = readLine()
    print("Password: ")
    val inputPassword = readLine()
    return user.authenticate(inputUsername.orEmpty(), inputPassword.orEmpty())
}
fun logInAsGuest(){
    var choice = 0
    do {
        printGuestChoices()
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
                    login()
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
    var choice = 0
    do {
        printOwnerCRUDChoices()
        try {
            choice = readln().toInt()
            when (choice) {
                1 -> {viewTouristSpotsDetails(setOfTouristSpots)}
                2 -> {viewRestaurantsDetails(setOfRestaurants)}
                3 -> {editTouristSpot(setOfTouristSpots)}
                4 -> {editRestaurant(setOfRestaurants)}
                5 -> {
                    setOfTouristSpots.add(addTouristSpot())
                }
                6-> {
                    setOfRestaurants.add(addRestaurant())
                }
                7 -> {
                    viewTouristSpotsDetails(setOfTouristSpots)
                    println("Enter the number of the tourist spot you want to remove: ")
                    val indexToBeRemoved = readln().toInt()
                    println("removed ${setOfTouristSpots[indexToBeRemoved - 1].name}")
                    setOfTouristSpots.removeAt(indexToBeRemoved - 1)
                }
                8 -> {
                    viewRestaurantsDetails(setOfRestaurants)
                    println("Enter the number of the restaurant you want to remove: ")
                    val indexToBeRemoved = readln().toInt()
                    println("removed ${setOfRestaurants[indexToBeRemoved - 1].name}")
                    setOfRestaurants.removeAt(indexToBeRemoved - 1)
                }
                9 -> {
                    login()
                }
                else -> {
                    println("Please enter a valid choice")
                }
            }
        } catch (nfe: NumberFormatException) {println("Please enter a number")}
    } while (choice != 0)
}

fun main() {
    println("Welcome to the Places in Baguio Capacity Application!")
    login()
}