package kot.decorator


class Bird {
    var age = 0

    fun fly() {
        println(if (age < 20) "flying" else "too old")
    }
}

class Lizard {
    var age = 0

    fun crawl() {
        println(if (age > 1) "crawling" else "too young")
    }
}

class Dragon {
    private val bird: Bird = Bird()
    private val lizard: Lizard = Lizard()

    var age : Int = 0
        set(value) {
            field = value
            bird.age = value
            lizard.age = value
        }

    fun fly() {
        this.bird.fly()
    }

    fun crawl() {
        this.lizard.crawl()
    }
}

fun main() {
    val dragon = Dragon()

    dragon.crawl()
}