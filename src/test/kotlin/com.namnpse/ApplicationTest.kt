package com.namnpse

import com.namnpse.models.ApiResponse
import com.namnpse.repository.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.assertEquals

class ApplicationTest {

    private val heroRepository: HeroRepository by inject(HeroRepository::class.java)

    @ExperimentalSerializationApi
    @Test
    fun `access root endpoint, assert correct response`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(response.status(), HttpStatusCode.OK)
                assertEquals(response.content, "Welcome to Heroes API!")
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all heroes endpoint, assert correct response`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/heroes").apply {
                assertEquals(response.status(), HttpStatusCode.OK)
                val actualDataSize = Json.decodeFromString<ApiResponse>(response.content ?: "")
                    .data.size
                assertEquals(expected = 5, actual = actualDataSize)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all heroes endpoint, get all pages, assert correct data`() {
        withTestApplication(moduleFunction = Application::module) {
            val pages = 1..3

            val heroes = heroRepository.heroes
            pages.forEach { page ->
                handleRequest(HttpMethod.Get, "/heroes?page=$page").apply {
                    assertEquals(
                        expected = HttpStatusCode.OK,
                        actual = response.status()
                    )
                    val actual = Json.decodeFromString<ApiResponse>(response.content ?: "")
                    val expected = ApiResponse(
                        success = true,
                        message = "OK",
                        prevPage = calculatePage(page = page)["prevPage"],
                        nextPage = calculatePage(page = page)["nextPage"],
                        data = heroes.filter { hero -> hero.id in (page - 1) * PAGE_SIZE + 1..(page) * PAGE_SIZE },
                        lastUpdated = actual.lastUpdated
                    )
                    assertEquals(
                        expected = expected,
                        actual = actual
                    )
                }
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access non existing endpoint,assert not found`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/heroess").apply {
                assertEquals(expected = HttpStatusCode.NotFound, actual = response.status())
                assertEquals(expected = "Page not Found.", actual = response.content)
            }
        }
    }

    @Test
    fun `access search heroes endpoint, query hero name, assert single hero result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/heroes/search?name=sas").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<ApiResponse>(response.content ?: "")
                    .data.size
                assertEquals(expected = 1, actual = actual)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search heroes endpoint, query hero name, assert multiple heroes result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/heroes/search?name=sa").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<ApiResponse>(response.content ?: "")
                    .data.size
                assertEquals(expected = 3, actual = actual)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search heroes endpoint, query an empty text, assert empty list as a result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/heroes/search?name=").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<ApiResponse>(response.content ?: "")
                    .data.size
                assertEquals(expected = 0, actual = actual)
            }
        }
    }

     private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..2) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..3) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 3) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }
}