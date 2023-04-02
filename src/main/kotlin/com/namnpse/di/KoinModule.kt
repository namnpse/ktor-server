package com.namnpse.di

import com.namnpse.repository.HeroRepository
import com.namnpse.repository.HeroRepositoryAlternative
import com.namnpse.repository.HeroRepositoryImpl
import com.namnpse.repository.HeroRepositoryImplAlternative
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
    single<HeroRepositoryAlternative> {
        HeroRepositoryImplAlternative()
    }
}