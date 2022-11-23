package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val bgColor: String,
    val funId: String,
    val image: String,
    val text: String,
    val visibility: Int
)