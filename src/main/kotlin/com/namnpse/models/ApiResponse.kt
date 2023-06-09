package com.namnpse.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val data: List<Hero> = emptyList(),
    val message: String? = null,
    val currentPage: Int? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val lastUpdated: Long? = null
)

@Serializable
data class HeroResponse(
    val success: Boolean,
    val message: String? = null,
    val data: Hero? = null,
)