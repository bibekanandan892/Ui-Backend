package com.example.domain.model.ui

import kotlinx.serialization.Serializable

@Serializable
data class MainScreen(
    val paddingStart: Int = 4,
    val paddingEnd: Int = 4,
    val paddingTop: Int = 4,
    val paddingBottom: Int = 4,
    val cornerSize: Int = 16,
    val elevation: Int = 4,
)
