package com.namnpse.repository

import com.namnpse.models.ApiResponse
import com.namnpse.models.Hero


class HeroRepositoryImplAlternative : HeroRepositoryAlternative {

    override val heroes by lazy {
        borutoHeroes
    }

    override suspend fun getAllHeroes(page: Int, limit: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "OK",
            prevPage = calculatePage(
                heroes = heroes,
                page = page,
                limit = limit
            )[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(
                heroes = heroes,
                page = page,
                limit = limit
            )[NEXT_PAGE_KEY],
            currentPage = page,
            data = getHeroes(
                heroes = heroes,
                page = page,
                limit = limit
            ),
            lastUpdated = System.currentTimeMillis()
        )
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            data = findHeroes(query = name)
        )
    }

    private fun calculatePage(
        heroes: List<Hero>,
        page: Int,
        limit: Int
    ): Map<String, Int?> {
        val allHeroes = heroes.windowed(
            size = limit,
            step = limit,
            partialWindows = true
        )
        require(page <= allHeroes.size)
        val prevPage = if (page == 1) null else page - 1
        val nextPage = if (page == allHeroes.size) null else page + 1
        return mapOf(
            PREVIOUS_PAGE_KEY to prevPage,
            NEXT_PAGE_KEY to nextPage
        )
    }

    private fun getHeroes(
        heroes: List<Hero>,
        page: Int,
        limit: Int
    ): List<Hero> {
        val allHeroes = heroes.windowed(
            size = limit,
            step = limit,
            partialWindows = true
        )
        require(page > 0 && page <= allHeroes.size)
        return allHeroes[page - 1]
    }

    private fun findHeroes(query: String?): List<Hero> {
        val founded = mutableListOf<Hero>()
        return if (!query.isNullOrEmpty()) {
            heroes.forEach { hero ->
                if (hero.name.lowercase().contains(query.lowercase())) {
                    founded.add(hero)
                }
            }
            founded
        } else {
            emptyList()
        }
    }
}