package kot.memento

data class Token(var value: Int)

data class Memento(val tokens: List<Int>)

class TokenMachine {
    private var tokens = mutableListOf<Token>()

    fun addToken(value: Int) : Memento {
        tokens.add(Token(value))
        return Memento(tokens.map { token -> token.value })
    }

    fun addToken(token: Token) : Memento {
        tokens.add(token)
        return Memento(tokens.map { token -> token.value })
    }

    fun revert(m: Memento) {
        tokens = mutableListOf()
        m.tokens.forEach { token -> tokens.add(Token(token)) }
    }

    override fun toString(): String {
        var s = ""
        tokens.forEach {token ->
            s += token.value.toString() + ", "
        }
        return s
    }
}

fun main() {
    val tm = TokenMachine()

    val m = tm.addToken(5)
    tm.addToken(Token(2))
    tm.addToken(Token(10))

    println(tm)
    tm.revert(m)
    println(tm)
}