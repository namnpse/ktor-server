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
    val abilities: List<String>,
    val gender: String = "Male",
    val month: String? = null,
    val day: String? = null,
    val family: List<String>? = null,
    val natureTypes: List<String>? = null,
    val realName: String? = null,
    val issues: Int? = null,
    val aliases: List<String>? = null,
)
