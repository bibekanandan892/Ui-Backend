package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class GridLayout(
    val backgroundColor: String,
    val backgroundCorner: Int,
    val columnCount: Int,
    val gridItem: GridItem,
    val pinColor: String
)