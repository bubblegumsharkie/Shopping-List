package com.countlesswrongs.shoppinglist.domain.model

data class ShopItem(
    val id: Int,
    val name: String,
    val amount: Int,
    val active: Boolean
)
