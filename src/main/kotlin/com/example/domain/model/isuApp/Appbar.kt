package com.example.domain.model.isuApp
import kotlinx.serialization.Serializable

@Serializable
data class Appbar(
    val backgroundColor: String,
    val items: Items
)