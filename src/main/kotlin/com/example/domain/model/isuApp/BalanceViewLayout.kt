package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class BalanceViewLayout(
    val Wallet1VIew: String,
    val Wallet2VIew: String,
    val addMoneyTextIconUi: AddMoneyTextIconUi,
    val background: String,
    val walletTextRefreshIconUI: WalletTextRefreshIconUI
)