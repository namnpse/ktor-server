package com.namnpse.plugins

import com.namnpse.routes.getAllHeroesAlternative
import com.namnpse.routes.root
import com.namnpse.routes.searchHeroes
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*
import javax.naming.AuthenticationException

fun Application.configureRouting() {
    routing {
        root()
        //        getAllHeroes()
        getAllHeroesAlternative()
        static("/images") {
            resources("images")
        }
        searchHeroes()

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