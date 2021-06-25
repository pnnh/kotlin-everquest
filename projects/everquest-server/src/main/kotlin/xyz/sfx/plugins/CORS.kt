package xyz.sfx.plugins

import io.ktor.features.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import queryQuest


val Application.corsHost get() = if (isDebug) "127.0.0.1" else "localhost"

fun Application.configureCORS() {
    install(ForwardedHeaderSupport)
    install(DefaultHeaders)
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Head)
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header(HttpHeaders.XForwardedProto)
        header(HttpHeaders.Accept)
        header(HttpHeaders.AcceptLanguage)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.ContentLanguage)
        header(HttpHeaders.AccessControlAllowHeaders)
        header(HttpHeaders.AccessControlAllowOrigin)
        host(corsHost)
        host("*", listOf("http", "https"))
        allowSameOrigin = true
        allowCredentials = true
        allowNonSimpleContentTypes = true
        maxAgeInSeconds = 3600 * 24
    }
}
