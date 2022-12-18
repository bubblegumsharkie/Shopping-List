package com.countlesswrongs.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId: Int = 0

    init {
        for (i in 1 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        shopList.add(item)
        updateList()
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList.remove(item)
        updateList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }

    private fun updateList() {
        shopListLiveData.value = shopList.toList()
    }

}
