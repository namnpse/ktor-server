package com.namnpse

import com.namnpse.plugins.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

// EngineMain: using external config in file application.conf
//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

// Embedded Server: config directly internal, no need config file: application.conf anymore
fun main() {
    embeddedServer(
        Netty,
        port = 8080,
    ) {
        install(ContentNegotiation) {

        }
        module() // name as func below
//        module2()
    }.start(wait = true)
}

@Suppress("unused") // application.conf references this main function. This annotation prevents the IDE from marking it as unused
fun Application.module() {
    // install any plugin here
//    install(Routing)
//    install(CallLogging)
    configureRouting()
}

@Suppress("unused") // application.conf references this main function. This annotation prevents the IDE from marking it as unused
fun Application.module2() {
//    configureRouting()
}