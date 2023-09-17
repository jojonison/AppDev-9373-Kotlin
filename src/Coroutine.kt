
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

    suspend fun parkCar(cardNo: Int) {
        try {
            availableSlot.acquire()
            println("Car $cardNo parked.")

            delay(2000)
        } catch (e: CancellationException) {

        }
    }
}

fun main() = runBlocking {
    print("Hello World")
}