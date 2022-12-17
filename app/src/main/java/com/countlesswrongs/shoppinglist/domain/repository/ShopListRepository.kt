package com.countlesswrongs.shoppinglist.domain.repository

import com.countlesswrongs.shoppinglist.domain.model.ShopItem

interface ShopListRepository {

    fun addShopItem(item: ShopItem)

    fun deleteShopItem(id: Int)

    fun disableShopItem(id: Int)

    fun editShopItem(id: Int)

    fun getShopItem(id: Int): ShopItem

    fun getShopList(): List<ShopItem>

}
