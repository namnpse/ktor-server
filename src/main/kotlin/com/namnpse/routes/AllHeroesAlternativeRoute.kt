package com.namnpse.routes

import com.namnpse.models.ApiResponse
import com.namnpse.repository.HeroRepositoryAlternative
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroesAlternative() {
    val heroRepositoryAlternative: HeroRepositoryAlternative by inject()

    get("/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            val limit = call.request.queryParameters["limit"]?.toInt() ?: 5
            val collection = call.request.queryParameters["collection"] ?: ""

            println("$page $limit $collection")

            val apiResponse = heroRepositoryAlternative.getAllHeroes(
                page = page, limit = limit, collection = collection,
            )
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Allowed."),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = true, message = "Heroes not Found."),
//                status = HttpStatusCode.NotFound
                status = HttpStatusCode.OK
            )
        } catch (e: Exception) {
            call.respond(
                message = ApiResponse(success = false, message = "Internal Server Error."),
                status = HttpStatusCode.InternalServerError
            )
        }
    }
}