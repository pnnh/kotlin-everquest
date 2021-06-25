package xyz.sfx.base64

import org.w3c.dom.Window
import xyz.sfx.SayHello

actual typealias Name = kotlin.js.JsName

external val window: Window
external fun unescape(str: String): String
external fun encodeURIComponent(str: String): String

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JsBase64Encoder
}

object JsBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        var string = src.toString()
        println("jjjjsEnv $jsEnv")
        if (isBroswer()) {
            val asciiStr = unescape(encodeURIComponent(src.toString()))
            string = window.btoa(asciiStr)
        } else {
            val buffer = js("Buffer").from(src)
            string = buffer.toString("base64") as String
        }
        return ByteArray(string.length) { string[it].toByte() }
    }
}

fun isBroswer(): Boolean {
    return jsEnv == "browser"
}

fun main() {
    SayHello("Hello from kotlin/js")
    println(greeting("base64"))
    console.log("Hello2222, ${greet()}")
    console.log("Hello333, ${greet2("aha")}")
}
@JsName("jsEnv")
val jsEnv = js("typeof window === 'undefined' ? 'nodejs' : 'browser'")

@JsName("greeting")
fun greeting(name: String) =
    "Hello, $name"

fun greet() = "world32323"

@JsName("greet2")
fun greet2(name: String): String {
    return "Hello, $name"
}

@JsName("greet3")
fun greet3(name: String) = greet2(name)

fun fnHahah(name: String): String {
    return "Hello, $name"
}