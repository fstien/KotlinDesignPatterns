package kot.state

class Lock(private val code: String) {
    private enum class states {
        LOCKED,
        OPEN
    }

    private var state : states = states.LOCKED

    fun unlock() {
        while (true) {
            when (state) {
                states.LOCKED -> {
                    println("Locked")
                    val input = readLine()
                    if (input == this.code) {
                        println("Correct code")
                        state = states.OPEN
                    }
                    else {
                        println("Incorrect code")
                    }
                }
                states.OPEN -> {
                    println("Open")
                    return
                }
            }
        }
    }


}

fun main() {
    val lock = Lock("1234")
    lock.unlock()
}