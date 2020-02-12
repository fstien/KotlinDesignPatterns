package kot.adapter

class Square(val Side: Int)

interface Rectangle {
    val width: Int
    val height: Int
    fun Area(): Int
}

class SquareToRectangleAdapter(square: Square): Rectangle {
    override val width: Int = square.Side
    override val height: Int = square.Side

    override fun Area(): Int {
        return this.width*this.height
    }
}