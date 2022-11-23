package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class BottomNavigationItem(
    val image: String,
    val selectedContentColor: String,
    val text: String,
    val unselectedContentColor: String,
    val visibility: Int
)