package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class Notification(
    val tintColor: String,
    val view: String
)