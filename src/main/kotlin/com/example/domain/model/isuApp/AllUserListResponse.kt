package com.example.domain.model.isuApp

import kotlinx.serialization.Serializable


@Serializable
data class AllUserListResponse(
    val allUser : List<String>
)
