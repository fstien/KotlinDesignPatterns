package kot.factory

import kotlin.math.cos
import kotlin.math.sin

class Point(val x: Double, val y: Double) {

    override fun toString(): String {
        return "Point: $x, $y"
    }

    companion object {
        fun newPolarPoint(rho: Double, theta: Double): Point {
            return Point(rho * cos(theta), rho * sin(theta))
        }
    }
}