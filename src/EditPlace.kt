
interface EditPlace {
    fun edit()
}

data class EditTouristSpot(
        val index: Int,
        val numVacantParking: Int
) : EditPlace {
    override fun edit() {
        setOfTouristSpots[index - 1].numVacantParking = numVacantParking
    }
}

data class EditRestaurant(
        val index: Int,
        val seatingCapacity: String
) : EditPlace {
    override fun edit() {
        setOfRestaurants[index - 1].seatingCapacity = seatingCapacity
    }
}
