package xyz.sfx.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import newQuest
import xyz.sfx.Greeter
import xyz.sfx.dsl.article
import xyz.sfx.dsl.html
//
//fun Application.main() {
//    println("jjjjfff2222")
//    install(ContentNegotiation) {
//        gson() {
//            setPrettyPrinting()
//        }
//        //json(Json.Default, ContentType.Application.Json)
//        //register(ContentType.Application.Json, JacksonConverter())
//    }
//}

fun Application.configureRouting() {
    println("jjjjfff")

    install(StatusPages) {
        // Status pages configuration
    }
    routing {
        get("/") {
            Greeter("World!").greet()
            var str = html{
                head {
                    title(){
                    }
                }
                body {
                    a(href="dffs"){}
                }
            }
            println("jjjjj\n" + str)
            call.respondText("Hello World!")
        }

        get("/post") {
            val str = article{
                title{
                    +"点点滴滴"
                }
                content() {
                    +"啊啊哈哈"
                }
            }

            call.respondText(str.toString())
        }
    }
}
