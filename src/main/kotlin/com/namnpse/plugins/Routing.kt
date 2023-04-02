package com.namnpse.plugins

import com.namnpse.routes.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*
import javax.naming.AuthenticationException

fun Application.configureRouting() {
    routing {
        root()
//        getAllHeroes()
        getAllHeroesAlternative()
        getMarvelHeroes()
        static("/images") {
            resources("images")
        }
        searchHeroes()
        searchMarvelHeroes()

        get("/exception") {
            throw AuthenticationException()
        }
    }
}

@kotlinx.serialization.Serializable
data class Person(
    val name: String,
    val age: String
)