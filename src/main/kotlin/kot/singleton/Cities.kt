package kot.singleton

import java.io.File


class Cities private constructor(){
    private val store = mutableMapOf<String, Int>()

    init {
        File("cities.csv").forEachLine {
            val line = it.split(",")
            store[line[0]] = line[1].toInt()
        }
    }

    fun Population(city: String): Int? {
        return store[city]
    }

    companion object {
        val instance = Cities()
    }
}