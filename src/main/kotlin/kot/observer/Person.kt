package kot.observer

interface Observer {
    fun update(message: String)
}

class Person {
    private val observers = mutableListOf<Observer>()

    fun catchFlu() {
        notifyObservers("Flu")
    }

    private fun notifyObservers(message: String) {
        this.observers.forEach { it.update(message) }
    }

    fun addObserver(observer: Observer) {
        this.observers.add(observer)
    }
}


class Doctor : Observer {
    override fun update(message: String) {
        println("I'm thinking about a cure for $message")
    }
}

class Mum : Observer {
    override fun update(message: String) {
        println("I'm picking you up from school")
    }
}

fun main() {
    val p = Person()

    p.addObserver(Doctor())
    p.addObserver(Mum())

    p.catchFlu()
}