package kot.builder

class HtmlBuilder(val rootName: String) {
    var root = HtmlElement(rootName)

    fun addChild(name: String, text: String = "") : HtmlBuilder {
        this.root.Elements.add(HtmlElement(name, text))
        return this
    }

    fun clear() {
        this.root = HtmlElement(rootName)
    }

    override fun toString(): String {
        return root.toString()
    }
}