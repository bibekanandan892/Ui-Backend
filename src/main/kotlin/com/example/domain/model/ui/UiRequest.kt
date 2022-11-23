package com.example.domain.model.ui

import com.example.domain.model.isuApp.UI
import kotlinx.serialization.Serializable

@Serializable
data class UiRequest(
    val UI: UI
)