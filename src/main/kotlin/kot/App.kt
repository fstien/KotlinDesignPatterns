package kot

import kot.singleton.Cities

fun main(args: Array<String>) {
    val cities = Cities.instance
    val cities2 = Cities.instance

    println(cities2 == cities2)
}
