package com.example.domain.model

import com.example.domain.model.ui.UI
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success : Boolean,
    val ui : UI? = null,
    val message : String? = null
)
