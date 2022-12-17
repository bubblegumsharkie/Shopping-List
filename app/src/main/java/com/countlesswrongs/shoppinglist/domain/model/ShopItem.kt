package com.countlesswrongs.shoppinglist.domain.model

data class ShopItem(
    val name: String,
    val amount: Int,
    val active: Boolean,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        const val UNDEFINED_ID = -1
    }
}
