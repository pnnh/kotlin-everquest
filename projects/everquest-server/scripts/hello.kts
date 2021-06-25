import java.io.File
import java.util.concurrent.TimeUnit

println("hello world")

val file = File(".")
file.listFiles().forEach(::println)

println("The End.")

val process = ProcessBuilder("curl", "baidu.com").start()
process.inputStream.reader(Charsets.UTF_8).use {
    println(it.readText())
}
process.waitFor(10, TimeUnit.SECONDS)