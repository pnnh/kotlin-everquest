package xyz.sfx.base64

expect annotation class Name(val name:String)

interface Base64Encoder {
    @Name("encode")
    fun encode(src: ByteArray): ByteArray

    @Name("encodeToString")
    fun encodeToString(src:ByteArray): String {
        val encoded = encode(src)
        return buildString(encoded.size) {
            encoded.forEach { append(it.toChar()) }
        }
    }
}

expect object Base64Factory {
    fun createEncoder(): Base64Encoder
}