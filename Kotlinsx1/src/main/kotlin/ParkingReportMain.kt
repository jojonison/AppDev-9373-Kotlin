
private fun MutableList<out Vehicle>.countAllCars(): Int {
    var count: Int = 0

    for (vehicle in this) {
        if (vehicle is Car) {
            count++
        }
    }
    return count;

}

private fun MutableList<out Vehicle>.countAllMotorcycles(): Int {
    var count: Int = 0

    for (vehicle in this) {
        if (vehicle is Motorcycle) {
            count++
        }
    }
    return count;
}


fun generateReport(listOfParkedCustomers: MutableList<out Vehicle>)  {
    println("%-10s%-10s%-20s%-20s%-30s%-20s".format("","Type", "Plate Number", "Hours of Stay", "Total Parking Fee",
        "Transaction ID"))
    for (vehicle in listOfParkedCustomers) {
        var type: Char = ' '
        var tpf: Int = 0
        var plateNumber: String= ""

        if (vehicle is Car) {
            type = 'C'
            tpf = vehicle.totalParkingFee
            plateNumber = vehicle.plateNumber
        }
        if (vehicle is Motorcycle) {
            type = 'M'
            tpf = vehicle.totalParkingFee
            plateNumber = vehicle.plateNumber
        }
        println(
            "%-10s%-10s%-20s%-20d%-30d%-20s".format(
                listOfParkedCustomers.indexOf(vehicle) + 1, type, plateNumber,
                vehicle.hoursOfStay, tpf, vehicle.transactionID
            )
        )
    }

    // Count number of cars and motorcycle in a parking lot
    val countOfCars = listOfParkedCustomers.countAllCars()
    val countOfMotorcycle = listOfParkedCustomers.countAllMotorcycles()

    println("Cars: $countOfCars\nMotorcycleS: $countOfMotorcycle")
}




fun main() {

    val listOfVehicle = mutableListOf(
        Car("asd198", 50, 6),
        Car("ASD098", 50, 3),
        Car("WEC499", 50, 2),
        Car("DKL523", 50, 6),


//        // Demo for Named arguments
//        Motorcycle(plateNumber = "SAI089", parkingFee = 25, hoursOfStay = 6),
//
//        Motorcycle(parkingFee = 25, plateNumber = "KLJ090", hoursOfStay = 6),
//
//        Motorcycle(hoursOfStay = 6, parkingFee = 25, plateNumber = "AKJ234"),
//
        Motorcycle("OIP293", 25, 6),
        Motorcycle("CSA235", 25, 6),

    );


    generateReport(listOfVehicle)
}