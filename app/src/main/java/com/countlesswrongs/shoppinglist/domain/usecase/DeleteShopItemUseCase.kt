package com.countlesswrongs.shoppinglist.domain.usecase

import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(id: Int) {
        shopListRepository.deleteShopItem(id)
    }

}
