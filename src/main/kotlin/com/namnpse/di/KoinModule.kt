package com.namnpse.di

import com.namnpse.repository.*
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
    single<HeroRepositoryAlternative> {
        HeroRepositoryImplAlternative()
    }
    single<MarvelHeroesRepository> {
        MarvelHeroesRepositoryImpl()
    }
}