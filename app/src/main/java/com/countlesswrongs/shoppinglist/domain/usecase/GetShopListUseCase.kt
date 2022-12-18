package com.countlesswrongs.shoppinglist.domain.usecase

import androidx.lifecycle.LiveData
import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }

}
