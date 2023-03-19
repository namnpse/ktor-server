package com.namnpse.plugins

import com.namnpse.di.koinModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDI() {
    install(Koin) {
        // logger for Koin
        slf4jLogger()
        modules(koinModule)
    }
}