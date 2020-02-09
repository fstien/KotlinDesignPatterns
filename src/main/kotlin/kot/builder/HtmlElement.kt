package kot.builder

class HtmlElement(
        private val Name: String,
        private val Text: String = "") {

    val Elements: MutableList<HtmlElement> = mutableListOf()

    fun toStringImpl(Indent: Int) : String {
        var out = " ".repeat(Indent) + "<${this.Name}>\n"

        if (this.Text.isNotEmpty()) {
            out += " ".repeat(Indent + 1) + this.Text + "\n"
        }

        for (e in this.Elements) {
            out += e.toStringImpl(Indent + 1)
        }

        out += " ".repeat(Indent) + "</${this.Name}>\n"
        return out
    }

    override fun toString(): String {
        return this.toStringImpl(0)
    }
}