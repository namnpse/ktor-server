package com.namnpse.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) {
            call.respond(
                message = "Page not Found.",
                status = HttpStatusCode.NotFound
            )
        }

        exception<AuthenticationException> {
            call.respond(
                message = "Unknown Error",
                status = HttpStatusCode.OK
            )
        }
    }
}