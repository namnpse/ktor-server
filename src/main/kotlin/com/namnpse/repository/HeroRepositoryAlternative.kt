package com.namnpse.repository

import com.namnpse.models.ApiResponse
import com.namnpse.models.Hero

interface HeroRepositoryAlternative {

    val heroes: List<Hero>

    suspend fun getAllHeroes(page: Int = 1, limit: Int = 5): ApiResponse
    suspend fun searchHeroes(name: String?): ApiResponse

}