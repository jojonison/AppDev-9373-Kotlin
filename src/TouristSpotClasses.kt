//open class TouristSpot(val name: String, var location: String) {
//    open fun getParkingInfo() {
//        println("Tourist spot does not provide parking spaces")
//    }
//    open fun showDetails() {
//        println("""
//             name: $name        Location: $location
//        """.trimIndent())
//    }
//}
//
//class TouristSpotWithParking(
//    name: String,
//    location: String,
//    private val parkingCapacity: Int,
//    private var numVacantParking: Int,
//    private var hasParking: Boolean
//) : TouristSpot(name, location) {
//    override fun getParkingInfo() {
//        println("""
//            Availability: $hasParking
//            Capacity: $parkingCapacity
//            Vacant: $numVacantParking
//        """.trimIndent())
//    }
//}