package kot.strategy

import kotlin.math.pow


interface DiscriminantStrategy {
    fun discriminant(a: Int, b: Int, c: Int) : Double
}

class OrdinaryDiscriminantStrategy : DiscriminantStrategy {
    override fun discriminant(a: Int, b: Int, c: Int) : Double {
        return b.toDouble().pow(2) - 4*a*c
    }
}

class RealDiscriminantStrategy : DiscriminantStrategy {
    override fun discriminant(a: Int, b: Int, c: Int) : Double {
        val disc = b.toDouble().pow(2) - 4*a*c
        if (disc < 0) return Double.NaN
        return disc
    }
}

class QuadraticSolver {
    var a : Int
    var b : Int
    var c : Int

    var discriminantStrategy : DiscriminantStrategy? = null

    init {
        print("a=")
        this.a = readLine()!!.toInt()

        print("b=")
        this.b = readLine()!!.toInt()

        print("c=")
        this.c = readLine()!!.toInt()

        while(this.discriminantStrategy == null) {
            print("Enter real or ordinary to select the discriminant strategy: ")
            val input = readLine()

            when(input) {
                "real" -> {
                    this.discriminantStrategy = RealDiscriminantStrategy()
                }
                "ordinary" -> {
                    this.discriminantStrategy = OrdinaryDiscriminantStrategy()
                }
                else -> {
                    println("Invalid discriminant strategy entered.")
                }
            }
        }
    }

    fun solutions() : List<String> {
        val disc = this.discriminantStrategy!!.discriminant(a, b, c)

        if (disc > 0) {
            return listOf(
                    ((-b-Math.sqrt(disc))/2*a).toString(),
                    ((-b+Math.sqrt(disc))/2*a).toString()
                )
        }
        else if (disc == 0.0) {
            return listOf(
                    (-b/2*a).toString()
                )
        }
        else {
            return listOf(
                    ((-b/2*a).toString() + " + (" + (Math.sqrt(-disc)/2*a).toString() + ")i"),
                    ((-b/2*a).toString() + " + (" + (-Math.sqrt(-disc)/2*a).toString() + ")i")
            )
        }
    }

}

fun main() {
    val qs = QuadraticSolver()
    for (solution in qs.solutions()) println(solution)
}
