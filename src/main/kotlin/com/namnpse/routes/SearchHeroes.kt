package com.namnpse.routes

import com.namnpse.repository.HeroRepository
import com.namnpse.repository.HeroRepositoryAlternative
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {
//    val heroRepository: HeroRepository by inject()
    val heroRepository: HeroRepositoryAlternative by inject()

    get("/heroes/search") {
        val name = call.request.queryParameters["name"]

        val apiResponse = heroRepository.searchHeroes(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }

    get("/heroes/{id}") {
        try {
            val heroId = call.parameters["id"]?.toInt()
            if (heroId != null) {
                val apiResponse = heroRepository.getHeroById(heroId = heroId)
                call.respond(
                    message = apiResponse,
                    status = HttpStatusCode.OK
                )
                return@get
            }
            call.respond(
                message = "Hero doesn't exist.",
                status = HttpStatusCode.NotFound
            )
        } catch (e: Exception) {
            call.respond(
                message = "Invalid hero id. Please check again.",
                status = HttpStatusCode.NotFound
            )
        }
    }

    get("/banners") {

        val apiResponse = heroRepository.getBanners()
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}