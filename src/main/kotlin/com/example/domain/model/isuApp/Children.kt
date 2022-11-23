package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class Children(
    val functionId: String,
    val icon: String?,
    val name: String
)