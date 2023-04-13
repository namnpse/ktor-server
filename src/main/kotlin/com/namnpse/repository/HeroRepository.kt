package com.namnpse.repository

import com.namnpse.models.ApiResponse
import com.namnpse.models.Hero
import com.namnpse.models.HeroResponse

interface HeroRepository {

    val heroes: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): ApiResponse

    suspend fun searchHeroes(name: String?): ApiResponse

    suspend fun getHeroById(heroId: Int): HeroResponse

    suspend fun getBanners(): ApiResponse

}