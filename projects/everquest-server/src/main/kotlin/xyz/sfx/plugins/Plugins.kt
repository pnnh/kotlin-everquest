package xyz.sfx.plugins

import io.ktor.features.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import queryQuest

val Application.envKind get() = environment.config.property("ktor.environment").getString()
val Application.isDebug get() = envKind == "debug"
val Application.isTest get() = envKind == "test"
val Application.isRelease get() = envKind != "debug" && envKind != "test"

fun Application.configurePlugins() {
    val env = environment.config.propertyOrNull("ktor.environment")?.getString()
    println("env $env")
    println("env22 $isDebug")
    install(Compression) {
        gzip {
            priority = 0.9
        }
        deflate() {
            priority = 1.0
        }
    }
    routing {
    }
}
