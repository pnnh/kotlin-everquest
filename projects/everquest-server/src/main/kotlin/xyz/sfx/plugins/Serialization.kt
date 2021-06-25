package xyz.sfx.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.Serializable
import newQuest
import queryQuest
import xyz.sfx.utils.NewPk
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*

@Serializable
data class Customer(val id: Int, val firstName: String, val lastName: String)

@Serializable
data class QuestPost(val title: String)

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/customer") {
            call.respond(Customer(1, "Jet", "Brains"))
        }
        get("/quest") {
            val questList = queryQuest("1")
            println(questList.count())
            if (questList.count() > 0) {
                call.respond(questList.first())     // 暂时不支持响应数组
            } else {
                call.respond(Customer(1, "Jet", "Brains"))
            }
        }
        get("/pk") {
            val pk = NewPk()
            call.respond(pk)
        }

        post("/quest") {
            val pk = NewPk()

            val questPost = call.receive<QuestPost>()
            if (questPost.title.isEmpty()) {
                call.response.status(HttpStatusCode.InternalServerError)
            } else {
                newQuest(pk, questPost.title)
                call.respond(Customer(2, "Jet2", "Brains2"))
            }
        }
    }
}
