package xyz.sfx

import com.typesafe.config.ConfigFactory
import io.ktor.config.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import org.jetbrains.exposed.sql.Database
import org.slf4j.LoggerFactory
import xyz.sfx.plugins.*


fun main() {
    val dsn = "jdbc:postgresql://localhost/everquest?user=postgres&password=example&ssl=false"
    Database.connect(dsn, driver = "org.postgresql.Driver")

    embeddedServer(CIO, environment = applicationEngineEnvironment {
        log = LoggerFactory.getLogger("ktor.application")
        config = HoconApplicationConfig(ConfigFactory.load())
        module {
            configureCORS()
            configureRouting()
            configureTemplating()
            configureSerialization()
            configurePlugins()
        }
        connector {
            port = 8080
            host = "0.0.0.0"
        }
    }) {
    }.start(wait = true)
}
