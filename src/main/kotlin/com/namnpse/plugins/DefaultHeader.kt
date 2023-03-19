package com.namnpse.plugins


import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import java.time.Duration

// customer header to every response from server, cache the data to our Android application every time we receive some values from our server
fun Application.configureDefaultHeader() {
    install(DefaultHeaders) {
        val oneYearInSeconds = Duration.ofDays(365).seconds
        header(
            name = HttpHeaders.CacheControl,
            value = "public, max-age=$oneYearInSeconds, immutable"
        )
    }
}