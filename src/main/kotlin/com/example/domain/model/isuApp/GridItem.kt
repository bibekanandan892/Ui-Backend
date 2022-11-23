package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class GridItem(
    val backgroundCorner: Int,
    val fontColor: String,
    val itemSize: Int,
    val itemSpace: Int,
    val items: List<Item>,
    val textSize: Int
)