package com.namnpse.models

import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String? = null,
    val day: String? = null,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>,
    val gender: String? = null,
    val classes: List<String>? = null,
)
