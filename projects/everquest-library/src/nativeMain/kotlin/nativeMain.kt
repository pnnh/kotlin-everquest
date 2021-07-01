import xyz.sfx.SayHello
import lib.*
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.cstr
import kotlinx.cinterop.toKString
import kotlinx.cinterop.usePinned

fun main() {
    SayHello("link")


    println("Hello Kotlin/Native!")


    ints(1, 2, 3, 4)
    uints(5, 6, 7, 8)
    doubles(9.0f, 10.0)


    val str = "this is a Kotlin String"
    pass_string(str.cstr)

    val useMe = return_string()?.toKString() ?: error("null pointer returned")
    println(useMe)

    val copyFromC = ByteArray(255).usePinned { pinned ->

        val useMe2 = copy_string(pinned.addressOf(0), pinned.get().size - 1)
        if (useMe2 != 0) throw Error("Failed to read string from C")
        pinned.get().toKString()
    }

    println(copyFromC)
}