package wf.my

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import wf.my.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSecurity()
        configureHTTP()
        configureSerialization()
        configureAdministration()
    }.start(wait = true)
}
