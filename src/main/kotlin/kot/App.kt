package kot

import kot.prototype.Address
import kot.prototype.Person
import kot.prototype.copy

fun main(args: Array<String>) {
    val p = Person(arrayOf("Francois", "Stiennon"), Address(10, "Lever Street"))

    val Roxane = p.copy()

    Roxane.names[1] = "d'Ales"

    println("stop")
}
