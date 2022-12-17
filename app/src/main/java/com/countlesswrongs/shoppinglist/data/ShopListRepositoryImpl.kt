package com.countlesswrongs.shoppinglist.data

import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId: Int = 0

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList.remove(item)
    }

    override fun editShopItem(item: ShopItem) {
        val oldItemValue = shopList.find { it.id == item.id }
        shopList.remove(oldItemValue)
        addShopItem(item)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find { item ->
            item.id == id
        } ?: throw RuntimeException("The item with $id was not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}
