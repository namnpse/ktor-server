package com.namnpse.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    // C1
//    routing {
//        get("/") {
//            call.respondText("Hello namnpse!!!")
//        }
//    }
    // C2: similar to above
    install(CallLogging)
    install(Routing) {

        static {
            resource("facebook.html") // single file
            resource("text.txt") // single file

            resources("static") // multiple files
        }

        static(remotePath = "assets") {
            resources("static") // multiple files
        }

        // C1
//        get("/") {
//            call.respondText("Hello namnpse!!!")
//        }
        // C2
        route(path = "/", method = HttpMethod.Get) {
            handle {
                call.respondText("Hello namnpse!!!")
            }
        }

        get("/users/{username}") {
            val userName = call.parameters["username"]
            if(userName == "Admin") {
                call.response.header(name = "CustomHeader", value = "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $userName!!!")
        }

        // query parameters
        get("user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
        }

        // try/catch, return fail response
        get("/person") {
            try {
                val person = Person(name = "nam", age = "26")
                // error, need to serialize
                call.respond(message = person, status = HttpStatusCode.OK)
            }catch (e: Exception) {
                call.respond(message = "${e.message}", status = HttpStatusCode.OK)
            }
        }

        get("/redirect") {
            call.respondRedirect(url = "/moved", permanent = false)
        }

        get("/moved") {
            call.respondText("Be redirected")
        }

    }
}

@kotlinx.serialization.Serializable
data class Person(
    val name: String,
    val age: String
)