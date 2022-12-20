package com.countlesswrongs.shoppinglist.presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.countlesswrongs.shoppinglist.R
import com.countlesswrongs.shoppinglist.domain.model.ShopItem
import com.countlesswrongs.shoppinglist.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var llShopList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llShopList = findViewById(R.id.ll_shop_list)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            showList(it)
        }
    }

    private fun showList(list: List<ShopItem>) {
        llShopList.removeAllViews()
        for (shopItem in list) {
            val layoutID = if (shopItem.active) {
                R.layout.item_enabled
            } else {
                R.layout.item_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutID, llShopList, false)
            val tvName = view.findViewById<TextView>(R.id.textViewItemName)
            val tvAmount = view.findViewById<TextView>(R.id.textViewAmount)
            tvName.text = shopItem.name
            tvAmount.text = shopItem.amount.toString()

            view.setOnLongClickListener {
                viewModel.changeStatusShopItem(shopItem)
                true
            }

            llShopList.addView(view)
        }
    }
}