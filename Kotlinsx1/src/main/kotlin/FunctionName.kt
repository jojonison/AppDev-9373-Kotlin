

class User(var email:String, var password: String, var age: Int) {
    override fun toString(): String {
        return "Email: $email \nAge: $age"
    }
}

fun main(args: Array<String>) {

//    var json=

    val user = User("@gmail.com", "password", 19)

    println(user.toString())

    println(reformat(str = "String", wordSeparator = ';', divideByCamelHumps = false))

//    Array<Any>
}

fun reformat(str:String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' '): String {
    return "$str\n$normalizeCase\n$upperCaseFirstLetter\n$divideByCamelHumps\n$wordSeparator"
}