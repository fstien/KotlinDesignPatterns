package kot

import kot.factory.Point
import kotlin.math.PI

fun main(args: Array<String>) {
    val p = Point.newPolarPoint(2.0, PI/2)
    println(p)
}
