package com.namnpse

import com.namnpse.models.ApiResponse
import com.namnpse.models.Hero
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

class BorutoAlternativeTest {

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
                        prevPage = calculatePage(heroes = heroes, page = page)[PREVIOUS_PAGE_KEY],
                        nextPage = calculatePage(heroes = heroes, page = page)[NEXT_PAGE_KEY],
                        currentPage = page,
                        data = getHeroes(
                            heroes = heroes,
                            page = page,
                        ),
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

    private fun calculatePage(
        heroes: List<Hero>,
        page: Int,
        limit: Int = 5
    ): Map<String, Int?> {
        val allHeroes = heroes.windowed(
            size = limit,
            step = limit,
            partialWindows = true
        )
        require(page <= allHeroes.size)
        val prevPage = if (page == 1) null else page - 1
        val nextPage = if (page == allHeroes.size) null else page + 1
        return mapOf(
            PREVIOUS_PAGE_KEY to prevPage,
            NEXT_PAGE_KEY to nextPage
        )
    }

    private fun getHeroes(
        heroes: List<Hero>,
        page: Int,
        limit: Int = 5
    ): List<Hero> {
        val allHeroes = heroes.windowed(
            size = limit,
            step = limit,
            partialWindows = true
        )
        require(page > 0 && page <= allHeroes.size)
        return allHeroes[page - 1]
    }
}