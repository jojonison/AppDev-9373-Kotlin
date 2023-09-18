package main.variables_nullsafety_casting

/**
 * Description: A sample program about garbage collection that
 * allows users to se a specific date and location for their garbage collection.
 */

import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT: String = "MM/dd/yyyy"
const val NOTIFICATION: String = "Thank you! We will notify you once your waste is about to be picked up."
const val REMINDER: String = "Reminder: Please Segregate your waste before %s"

fun main () {


    // Variable declaration
    val username: String = "user"
    val password: String = "abcd1234"

    println("Welcome to Waste Management - Baguio City!")
    // User login
    while (true) {
        print("Username: ")
        val user: String? = readlnOrNull()
        print("Password:")
        val pass: String? = readlnOrNull()
        if (user == username && pass == password) {
            break
        } else {
            println("Invalid username or password! Please try again")
        }
    }

    while (true) {

        // Type inference for variable and property types
        val notificationsEnabled: Boolean = false

        println("Please enter the date you want your trash to be collected [MM/dd/yyyy]: ")
        val pickupDate: String = readln()

        println("Please enter the location of the pick-up point: ")
        val pickupLocation: String = readln()

        try {
            val dateFormat = SimpleDateFormat(DATE_FORMAT)
            val parsedDate: Date = dateFormat.parse(dateFormat.format(dateFormat.parse(pickupDate)))
            val calendar: Calendar = Calendar.getInstance()
            calendar.time = parsedDate
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            val reminderDate: Date = calendar.time
            println(String.format(REMINDER, dateFormat.format(reminderDate)))
        } catch (e: Exception) {
            println("Invalid date format.")
            continue
        }

        // Null-safety
        if (notificationsEnabled) {
            println(NOTIFICATION)
        } else {
            println("Thank you! Your waste will be picked up on $pickupDate at $pickupLocation")
        }

        // Smart Casts + typecast/converting types
        val wasteType: Any = "Plastic"
        if (wasteType is String) {
            val wasteString: String = wasteType
            println("Please make sure to properly segregate your $wasteString waste. ")
        }


        println("Do you want to log out? [Y/N]")
        when (readln().uppercase(Locale.getDefault())) {
            "Y" -> {
                println("Thank you for using our program!")
                return
            }
        }
    }
}