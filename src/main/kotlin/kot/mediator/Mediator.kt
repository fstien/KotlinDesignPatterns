package kot.mediator

class Participant(val mediator: Mediator) {

    init {
        mediator.addParticipant(this)
    }

    var Value: Int = 0

    fun Say(n: Int) {
        mediator.broadCast(this, n)
    }

    override fun toString(): String {
        return "Value: $Value"
    }
}


class Mediator {

    private val participants = mutableListOf<Participant>()

    fun addParticipant(participant: Participant) {
        participants.add(participant)
    }

    fun broadCast(source: Participant, n: Int) {
        for (particiant in participants) {
            if (particiant != source) {
                particiant.Value += n
            }
        }
    }
}


fun main() {
    val m = Mediator()

    val p1 = Participant(m)
    val p2 = Participant(m)
    val p3 = Participant(m)

    p1.Say(2)
    p2.Say(3)
    p3.Say(1)

    println(p1)
    println(p2)
    println(p3)
}