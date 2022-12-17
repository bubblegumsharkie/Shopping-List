package com.countlesswrongs.shoppinglist.domain.usecase

import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }

}
