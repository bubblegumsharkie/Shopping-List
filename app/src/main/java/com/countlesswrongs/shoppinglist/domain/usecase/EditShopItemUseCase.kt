package com.countlesswrongs.shoppinglist.domain.usecase

import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(id: Int) {
        shopListRepository.editShopItem(id)
    }

}
