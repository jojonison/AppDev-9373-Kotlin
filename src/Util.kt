fun giveSetOfTouristSpots() : MutableList<TouristSpots> {
    val place1 = TouristSpots("Place1", "Doon", 10)
    val place2 = TouristSpots("Place2", "Diyan", 4)
    val place3 = TouristSpots("Place3", "There", 6)
    val place4 = TouristSpots("Place4", "Diretso ka lang", 0)
    return mutableListOf(place1,place2,place3,place4)
}

fun giveSetOfRestaurants() : MutableList<Restaurant> {
    val place1 = Restaurant("Amy's Baking Company", "Di ko alam", "Pizzaria", "Full")
    val place2 = Restaurant("Jollibee", "Sa tabi ng Mcdo", "Fast Food", "Has Vacant Seats")
    val place3 = Restaurant("McDonald's", "Sa tabi ng Jollibee", "Fast Food", "Has Vacant Seats")
    val place4 = Restaurant("Burger King", "SM", "Fast Food", "Full")
    return mutableListOf(place1,place2,place3,place4)
}

fun printOwnerCRUDChoices() {
    println("""
        What to do?:
        1 - View tourist spots' details
        2 - View restaurants' details
        3 - Edit tourist spots' parking vacancies
        4 - Edit restaurants' seating capacity
        5 - Add tourist spot
        6 - Add restaurant
        7 - Remove tourist spot
        8 - Remove restaurant
        
        9 - Log Out
    """.trimIndent())
}

fun addTouristSpot() : TouristSpots {
    println("Name: ")
    val name = readln()
    println("Location: ")
    val location = readln()
    println("How many parking spaces?: ")
    val vacant = readln().toInt()
    return TouristSpots(name,location,vacant)
}

fun addRestaurant() : Restaurant {
    println("Name: ")
    val name = readln()
    println("Location: ")
    val location = readln()
    println("Type: ")
    val type = readln()
    println("Seating Capacity?: ")
    val capacity = readln()
    return Restaurant(name,location,type, capacity)
}

