package com.countlesswrongs.shoppinglist.domain.usecase

import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

class DisableShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun disableShopItem(id: Int) {
        shopListRepository.disableShopItem(id)
    }

}
