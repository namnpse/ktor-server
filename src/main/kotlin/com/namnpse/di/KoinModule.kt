package com.namnpse.di

import com.namnpse.repository.HeroRepository
import com.namnpse.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
}