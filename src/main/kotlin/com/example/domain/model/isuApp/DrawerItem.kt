package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class DrawerItem(
    val children: List<Children>?,
    val functionId: String,
    val icon: String?,
    val name: String
)