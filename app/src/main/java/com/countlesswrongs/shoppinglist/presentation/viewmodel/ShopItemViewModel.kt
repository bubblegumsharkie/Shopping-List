package com.countlesswrongs.shoppinglist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.countlesswrongs.shoppinglist.data.ShopListRepositoryImpl
import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.domain.usecase.AddShopItemUseCase
import com.countlesswrongs.shoppinglist.domain.usecase.EditShopItemUseCase
import com.countlesswrongs.shoppinglist.domain.usecase.GetShopItemUseCase

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItemById(id: Int) {
        val item = getShopItemUseCase.getShopItem(id)
    }

    fun addShopItem(inputName: String?, inputAmount: String?) {
        val name = parseName(inputName)
        val amount = parseAmount(inputAmount)
        val validFields = validateInput(name, amount)
        if (validFields) {
            addShopItemUseCase.addShopItem(ShopItem(name, amount, true))
        }
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseAmount(inputAmount: String?): Int {
        return try {
            inputAmount?.trim()?.toInt() ?: 0
        } catch (e: java.lang.Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        //TODO: Show errors
        if (name.isBlank()) {
            result = false
        }
        if (count <= 0) {
            result = false
        }
        return result
    }

}
