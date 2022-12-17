package com.countlesswrongs.shoppinglist.domain.repository

import com.countlesswrongs.shoppinglist.domain.model.ShopItem

interface ShopListRepository {

    fun addShopItem(item: ShopItem)

    fun deleteShopItem(item: ShopItem)

    fun disableShopItem(id: Int)

    fun editShopItem(item: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun getShopList(): List<ShopItem>

}
