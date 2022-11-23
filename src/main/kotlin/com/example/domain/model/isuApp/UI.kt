package com.example.domain.model.isuApp

import kotlinx.serialization.Serializable

@Serializable
data class UI(
    val id : String,
    val appbar: Appbar,
    val balanceViewLayout: BalanceViewLayout,
    val bottomBar: BottomBar,
    val drawerLayout: DrawerLayout,
    val gridLayout: GridLayout
)