import java.util.Scanner

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    var output = 0;

    println("Console Calcutor")
    while (true) {
        var operator = "";

        print("Enter first number [E/e to exit]: ")
        val firstNum = reader.nextLine().toInt()
         operatorBreak@ while (operator != "+" || operator != "-" || operator != "*" ||
            operator != "/") {
            print("Choose an operator (+ , - , *, /) [E/e to exit]: ")
            operator = reader.nextLine();
             if (operator != "+" || operator != "-" || operator != "*" ||
                 operator != "/")
                 println("asdcsa")
                break@operatorBreak
         }

        print("Enter second number [E/e to exit]: ")
        val secondNum = reader.nextLine().toInt()
        when (operator) {
            "+" -> {
                output = firstNum + secondNum
                println("Sum is: $output")
            }
            "-" -> {
                output = firstNum - secondNum
                println("Difference is: $output")
            }
            "*" -> {
                output = firstNum * secondNum
                println("Product is: $output")

            }
            "/" -> {
                output = firstNum / secondNum
                println("Quotient is: $output")

            }
        }


    }
}