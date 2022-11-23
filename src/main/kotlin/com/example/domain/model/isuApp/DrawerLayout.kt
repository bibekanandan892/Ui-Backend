package com.example.domain.model.isuApp


import kotlinx.serialization.Serializable

@Serializable
data class DrawerLayout(
    val backgroundColor: String,
    val childrenIconSize: Int,
    val childrenSpaceInBetween: Int,
    val childrenTextColor: String,
    val childrenTextSize: Int,
    val commonItems: List<CommonItem>,
    val customerName: String,
    val drawerItems: List<DrawerItem>,
    val iconSize: Int,
    val spaceInBetween: Int,
    val textColor: String,
    val textSize: Int,
    val viewMoreColor: String,
    val viewMoreIcon: Int?
)