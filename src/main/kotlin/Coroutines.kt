/*
*
*   Programmer: Maervin Villalobos
*   Date: 09 - 17 - 2023
*   Description: A sample problem about parking space
*   that simulates of cars arriving and parking
*
*/

import kotlinx.coroutines.*

/* The ParkingLot class represents a parking lot with a given capacity and provides methods to park and release cars. */
class ParkingLot(capacity: Int) {
    // Variables declarations
    private val availableSlots = mutableListOf<Boolean>()
    private val random = java.util.Random()
    private var totalCarsParked = 0
    private var carCounter = 1

    // Initialize all spots as available
    init {
        repeat(capacity) { availableSlots.add(true) }
    }

    /**
     * Simulates a car parking in a spot, staying for 2 seconds, and then departing from the spot.
     */
    suspend fun parkCar() {
        val slotNo = findAvailableSpot()
        if (slotNo != -1) {
            val carNo = carCounter++
            // Print if a car park
            println("Car $carNo parked in spot $slotNo.")

            // Simulate car parking for 2 seconds
            delay(2000)

            // Print if a car departed from a spot
            println("Car $carNo departed from spot $slotNo.")
            // Open the parking slot
            releaseSpot(slotNo)
        } else {
            println("Car $carCounter couldn't find a parking spot and exited.")
            carCounter++
        }

        // total numbers of cars that are parked
        totalCarsParked++

        // Shows the number of available slot after 20 cars parked
        if (totalCarsParked % 20 == 0) {
            updateAvailableSlots()
        }
    }

    /**
     * findAvailableSpot finds an available parking spot by randomly selecting an index from a list of
     * available spots and marking it as occupied.
     *
     * It returns an integer value representing the parking spot number. If there are
     * available spots, it returns the number of the randomly selected spot that was marked as occupied. If there are no
     * available spots, it returns -1 to indicate that there are no available spots.
     */
    private fun findAvailableSpot(): Int {
        // Create a list of indices representing available spots
        val availableSpotsIndices = mutableListOf<Int>()
        for (index in availableSlots.indices) {
            if (availableSlots[index]) {
                availableSpotsIndices.add(index)
            }
        }

        // Check if there are available spots
        return if (availableSpotsIndices.isNotEmpty()) {
            // Randomly select an index from the list of available spots
            val randomIndex = random.nextInt(availableSpotsIndices.size)
            // Get the parking spot number using the randomly selected index
            val spotNo = availableSpotsIndices[randomIndex]

            // Mark the selected spot as occupied
            availableSlots[spotNo] = false

            // Return the parking spot number
            spotNo
        } else {
            // If there are no available spots, return to indicate no available spots
            -1
        }
    }

    /**
     * Counts the number of available parking slots and prints the result.
     */
    private fun updateAvailableSlots() {
        val availableSlots = availableSlots.count { it }
        println("Available parking slots: $availableSlots")
    }

    /**
     * Updates the availability of a parking spot.
     * @param spotNo The spotNo parameter is an integer that represents the spot number of a parking spot.
     */
    private fun releaseSpot(spotNo: Int) {
        availableSlots[spotNo] = true
    }
}

/**
 * Simulates cars arriving at a parking lot and parking their cars
 * randomly within a specified time range.
 */
fun main() = runBlocking {
    // The total capacity of the parking lot
    val parkingLot = ParkingLot(capacity = 30)
    // Creates a list of 100 coroutines. Each coroutine represents a car arriving
    // at the parking lot and parking their car.
    val cars = List(100) {
        launch {
            // Simulate random arrival time
            delay((1..5).random() * 1000L)
            parkingLot.parkCar()
        }
    }

    // Used to wait for all the coroutines in the `cars` list to complete before
    // continuing with the execution of the program. It ensures that all the cars
    // have finished parking before the program terminates.
    cars.joinAll()
}
