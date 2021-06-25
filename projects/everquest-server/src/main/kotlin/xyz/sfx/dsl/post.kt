package xyz.sfx.dsl

interface Widget {
    fun render(builder: StringBuilder, indent: String)
}

class TextWidget(val text: String): Widget {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

@DslMarker
annotation class NodeMarker

@NodeMarker
abstract class Node(val name: String): Widget {
    val children = arrayListOf<Widget>()
    val attributes = hashMapOf<String, String>()

    protected fun <T: Widget> initNode(node: T, init: T.() -> Unit): T {
        node.init()
        children.add(node)
        return node
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            c.render(builder, indent + "  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes(): String {
        val builder = StringBuilder()
        for ((attr, value) in attributes) {
            builder.append(" $attr=\"$value\"")
        }
        return builder.toString()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class NodeWithText(name: String): Node(name) {
    operator fun String.unaryPlus() {
        children.add(TextWidget(this))
    }
}

class ATitle : NodeWithText("title")

class AContent : NodeWithText("content")

class Article : NodeWithText("article") {
    fun title(init: ATitle.() -> Unit) = initNode(ATitle(), init)
    fun content(init: AContent.() -> Unit) = initNode(AContent(), init)
}

fun article(init: Article.() -> Unit): Article {
    val article = Article()
    article.init()
    return article
}