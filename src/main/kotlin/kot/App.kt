package kot

import kot.builder.HtmlBuilder

fun main(args: Array<String>) {
    val b = HtmlBuilder("html")
    b.addChild("p", "hello world")
    .addChild("p", "dear francois")
    println(b)
}
