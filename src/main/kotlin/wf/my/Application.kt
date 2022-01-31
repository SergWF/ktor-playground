package wf.my

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import wf.my.plugins.configureAdministration
import wf.my.plugins.configureDI
import wf.my.plugins.configureHTTP
import wf.my.plugins.configureRouting
import wf.my.plugins.configureSerialization

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    configureDI()
//    configureSecurity()
    configureRouting()
    configureHTTP()
    configureSerialization()
    configureAdministration()
}


