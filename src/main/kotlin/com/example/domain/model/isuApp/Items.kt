package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class Items(
    val menue: Menue,
    val notification: Notification,
    val qrCode: QrCode
)