package com.countlesswrongs.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.countlesswrongs.shoppinglist.domain.model.ShopItem

interface ShopListRepository {

    fun addShopItem(item: ShopItem)

    fun deleteShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

}
