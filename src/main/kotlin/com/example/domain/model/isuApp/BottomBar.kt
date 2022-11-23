package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class BottomBar(
    val backgroundColor: String,
    val bottomNavigationItem: List<BottomNavigationItem>
)