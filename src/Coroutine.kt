
/*
*
*   Programmer: Maervin Villalobos
*   Date: 09 - 17 - 2023
*   Description: A sample problem about parking space
*   that simulates if the car is parked
*
*
*/

import kotlinx.coroutines.*
import java.util.concurrent.*

class ParkingLot(capacity: Int) {
    private val availableSlot = Semaphore(capacity)

    suspend fun parkCar(carNo: Int) {
        try {
            availableSlot.acquire()
            println("Car $carNo parked.")

            delay(2000)
            println("Car $carNo departed.")
        } catch (e: CancellationException) {
            println("Car $carNo parking was interrupted")
        } finally {
            availableSlot.release()
        }
    }
}

fun main() = runBlocking {
    val parkingLot = ParkingLot(capacity = 5)
    val cars = List(10) { carId ->
        launch {
            try {
                delay((1..5).random() * 1000L)
                parkingLot.parkCar(carId)
            } catch (e: Exception) {
                println("Car $carId encountered an error: ${e.message}")
            }
        }
    }

    delay(8000)
    cars.forEach { it.cancel() }

    cars.joinAll()
}