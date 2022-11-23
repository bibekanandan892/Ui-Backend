package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class CommonItem(
    val children: List<Children>?,
    val functionId: String,
    val icon: String?,
    val name: String
)