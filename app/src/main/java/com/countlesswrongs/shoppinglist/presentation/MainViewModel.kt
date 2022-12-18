package com.countlesswrongs.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.countlesswrongs.shoppinglist.data.ShopListRepositoryImpl
import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.domain.usecase.DeleteShopItemUseCase
import com.countlesswrongs.shoppinglist.domain.usecase.EditShopItemUseCase
import com.countlesswrongs.shoppinglist.domain.usecase.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()


    fun getShopListFromDB() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopListFromDB()
    }

    fun changeStatusShopItem(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(active = !shopItem.active)
        editShopItemUseCase.editShopItem(newShopItem)
        getShopListFromDB()
    }

}
