package com.namnpse.repository

import com.namnpse.models.ApiResponse
import com.namnpse.models.Hero
import com.namnpse.models.HeroResponse

const val PAGE_SIZE = 5
const val NEXT_PAGE_KEY = "nextPage"
const val PREVIOUS_PAGE_KEY = "prevPage"

class HeroRepositoryImpl : HeroRepository {

    override val heroes: List<Hero> by lazy {
        borutoHeroes
    }

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "OK",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            currentPage = page,
            data = heroes.filter { hero -> hero.id in (page-1)* PAGE_SIZE + 1 ..(page)* PAGE_SIZE  },
            lastUpdated = System.currentTimeMillis()
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..2) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..3) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 3) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "OK",
            data = findHeroes(query = name)
        )
    }

    override suspend fun getHeroById(heroId: Int): HeroResponse {
        return HeroResponse(
            success = true,
            message = "OK",
            data = findHeroById(heroId = heroId)
        )
    }

    override suspend fun getBanners(): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
//            data = findHeroes(query = name)
        )
    }

    private fun findHeroes(query: String?): List<Hero> {
        val result = mutableListOf<Hero>()
        return if (!query.isNullOrEmpty()) {
            (heroes+marvelHeroes).forEach { hero ->
                if (hero.name.lowercase().contains(query.lowercase())) {
                    result.add(hero)
                }
            }
            result
        } else {
            emptyList()
        }
    }

    private fun findHeroById(heroId: Int): Hero? {
        return (heroes+marvelHeroes).find { it.id == heroId }
    }
}