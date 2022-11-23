package com.example.domain.model

import com.example.domain.model.isuApp.Item
import kotlinx.serialization.Serializable


@Serializable
data class GridUpdateRequest(
    val uiId : String,
    val items : List<Item>
)
