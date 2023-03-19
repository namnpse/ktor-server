package com.namnpse

import com.namnpse.plugins.*
import io.ktor.application.*

// EngineMain: using external config in file application.conf
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

// Embedded Server: config directly internal, no need config file: application.conf anymore
//fun main() {
//    embeddedServer(
//        Netty,
//        port = 8080,
//    ) {
//        install(ContentNegotiation) {
//
//        }
//        module() // name as func below
//    }.start(wait = true)
//}

@Suppress("unused") // application.conf references this main function. This annotation prevents the IDE from marking it as unused
fun Application.module() {
    configureDI()
    configureDefaultHeader()
    configureRouting()
    configureMonitoring()
    configureSerialization()
    configureStatusPages()
}