package com.namnpse

import com.namnpse.models.ApiResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ApplicationTest {

    @Test
    fun `access root endpoint, assert correct response`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(response.status(), HttpStatusCode.OK)
                assertEquals(response.content, "Welcome to Heroes API!")
            }
        }
    }

    @Test
    fun `access all heroes endpoint, assert correct response`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/heroes").apply {
                assertEquals(response.status(), HttpStatusCode.OK)
                assertNotEquals(response.content, "Welcome to Heroes API!")
                val actualDataSize = Json.decodeFromString<ApiResponse>(response.content ?: "")
                    .data.size
                assertEquals(expected = 15, actual = actualDataSize)
            }
        }
    }
}