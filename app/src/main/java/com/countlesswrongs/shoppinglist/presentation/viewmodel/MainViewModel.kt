package com.countlesswrongs.shoppinglist.presentation.viewmodel

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

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeStatusShopItem(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(active = !shopItem.active)
        editShopItemUseCase.editShopItem(newShopItem)
    }

}