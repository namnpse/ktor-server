package com.namnpse.repository

import com.namnpse.models.ApiResponse
import com.namnpse.models.Hero
import com.namnpse.models.HeroResponse

interface HeroRepositoryAlternative {

    val heroes: List<Hero>

    suspend fun getAllHeroes(page: Int = 1, limit: Int = 5, collection: String): ApiResponse

    suspend fun searchHeroes(name: String?): ApiResponse

    suspend fun getHeroById(heroId: Int): HeroResponse

    suspend fun getBanners(): ApiResponse

}