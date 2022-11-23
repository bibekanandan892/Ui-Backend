package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class AddMoneyTextIconUi(
    val aadMoneyView: String,
    val icontintColor: String,
    val textColor: String
)