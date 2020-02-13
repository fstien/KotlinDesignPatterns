package kot.proxy

interface IPerson {
    fun Drink(): String
    fun Drive(): String
    fun DrinkAndDrive(): String
}

class Person(var Age: Int) : IPerson {
    override fun Drink(): String {
        return "drinking"
    }

    override fun Drive(): String {
        return "driving"
    }

    override fun DrinkAndDrive(): String {
        return "drinking and driving"
    }
}

class ResponsiblePerson(val person: Person) : IPerson {

    override fun Drink(): String {
        return if (person.Age >= 18) "drinking" else "too young"
    }

    override fun Drive(): String {
        return if (person.Age >= 16) "driving" else "too youn"
    }

    override fun DrinkAndDrive(): String {
        return "dead"
    }

    var Age : Int
        get() {
            return person.Age
        }
        set(value) {
            this.person.Age = value;
        }
}

fun main() {
    val person = ResponsiblePerson(Person(17))
    println(person.Drink())
    println(person.Drive())

    person.Age = 20
    println(person.Drink())
}