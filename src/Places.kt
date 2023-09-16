abstract class Place(
    val name: String,
    val location: String
) {
    abstract fun showDetails()
}

class TouristSpots(
    name: String,
    location: String,
    private var numVacantParking: Int,
) : Place(name, location) {
    override fun showDetails() {
        println("""
            Tourist Spot:           $name
            Location:               $location
            Vacant Parking Space:   $numVacantParking
        """.trimIndent())
    }
}

class Restaurant(
    name: String,
    location: String,
    private val restaurantType: String,
    private val seatingCapacity: String,
) : Place(name, location) {
    override fun showDetails() {
        println("""
            Restaurant:         $name
            Location:           $location
            Restaurant Type:    $restaurantType
            Seating Capacity:   $seatingCapacity
        """.trimIndent())
    }
}