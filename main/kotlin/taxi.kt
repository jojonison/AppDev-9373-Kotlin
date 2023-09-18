import java.util.*

data class Taxi(val taxiNumber: String, val baseFare: Double, val perKilometerRate: Double, val quota: Double) {
    var isBooked: Boolean = false

    operator fun plus(otherTaxi: Taxi): Double {
        return this.quota + otherTaxi.quota
    }

    operator fun invoke() {
        if (!isBooked) {
            println("\nTaxi $taxiNumber has been booked in Baguio City.\n")
            isBooked = true
        } else {
            println("\nTaxi $taxiNumber is already booked.\n")
        }
    }


    inline fun calculateFare(distance: Double, fareCalculator: (Double) -> Double): Double {
        return fareCalculator(distance)
    }
}


val taxis = mutableListOf<Taxi>()

fun printMenuUser() {
    println("\nBaguio City Taxi Booking System")
    println("Welcome to the City of Pines!\n\n\n")
    println("1. Book a taxi")
    println("2. Get the total spent amount on taxi fares")
    println()
    getUserChoice()
}

fun getUserChoice() {
    val kbd = Scanner(System.`in`)
    println("Enter choice: ")
    val choice = kbd.nextInt()

    when (choice) {
        1 -> bookTaxi()
        2 -> getTotalQuota()
        3 -> printMenuUser()
        else -> println("Invalid choice")
    }
}

fun loginUser() {
    val taxi1 = Taxi("T123", 40.0, 13.0, 100.00)
    val taxi2 = Taxi("T456", 40.0, 15.0, 550.00)

    taxis.addAll(listOf(taxi1, taxi2))

    val credentials = mapOf(
        "" to "",
        "admin" to "admin"
    )

    val kbd = Scanner(System.`in`)
    println("Username: ")
    val user = kbd.nextLine()
    println("Password: ")
    val pass = kbd.nextLine()

    when {
        credentials[user] == pass -> {
            println("LOGGED IN\n")
            when (user) {
                "" -> printMenuUser()
            }
        }

        else -> println("INVALID CREDENTIALS")
    }
}

fun bookTaxi() {
    println("\nAvailable Taxis in Baguio City: ")
    taxis.forEachIndexed { index, taxi ->
        println("${index + 1}. Taxi ${taxi.taxiNumber}")
    }

    val kbd = Scanner(System.`in`)
    print("Choose a taxi (1-${taxis.size}): ")
    val choice = kbd.nextInt()

    val selectedTaxi = taxis.getOrNull(choice - 1)

    if (selectedTaxi != null && !selectedTaxi.isBooked) {
        selectedTaxi()
        println("\nKilometers to your destination: ")
        val distanceInKilometers = kbd.nextDouble()

        val fare = selectedTaxi.calculateFare(distanceInKilometers) { distance ->
            selectedTaxi.baseFare + (distance * selectedTaxi.perKilometerRate)
        }
        println("\nTaxi Fare for $distanceInKilometers kilometers for Taxi ${selectedTaxi.taxiNumber}: ₱$fare")

        println("Press enter to continue")
        kbd.nextLine()
        kbd.nextLine()
    } else {
        println("Invalid choice or taxi already booked.")
    }

    printMenuUser()
}

fun getTotalQuota() {
    val totalQuota = taxis[0] + taxis[1]
    println("\nTotal Quota for all taxis: $totalQuota")

    printMenuUser()
}


fun main() {
    loginUser()
}





