package kot.command


class BankAccount {

    private var balance = 0

    fun Deposit(amount: Int) : Boolean {
        balance += amount
        println("deposited ${amount}, new balance ${balance}")
        return true
    }

    fun Withdraw(amount: Int) : Boolean {
        if (balance < amount)
            return false

        balance -= amount
        println("withdrew ${amount}, new balance ${balance}")
        return true
    }

    override fun toString(): String {
        return "balance: ${balance}"
    }
}

interface ICommand {
    fun Call()
    fun Undo()
}

class BankAccountCommand(
        val bankAccount: BankAccount,
        val type: CommandType,
        val amount: Int) : ICommand {
    var success = false

    override fun Call() {
        when (type) {
            CommandType.Deposit -> {
                success = bankAccount.Deposit(amount)
            }
            CommandType.Withdraw -> {
                success = bankAccount.Withdraw(amount)
            }
        }
    }

    override fun Undo() {
        if (!success) return
        when (type) {
            CommandType.Deposit -> {
                bankAccount.Withdraw(amount)
            }
            CommandType.Withdraw -> {
                bankAccount.Deposit(amount)
            }
        }
    }

}

enum class CommandType {
    Withdraw, Deposit
}


fun main() {
    val ba = BankAccount()

    val commands = listOf(
        BankAccountCommand(ba, CommandType.Deposit, 100),
        BankAccountCommand(ba, CommandType.Deposit, 10),
        BankAccountCommand(ba, CommandType.Withdraw, 60),
        BankAccountCommand(ba, CommandType.Withdraw, 80)
    )

    for (command in commands) {
        command.Call()
    }

    println(ba)

    for (command in commands.asReversed()) {
        command.Undo()
    }

    println(ba)
}