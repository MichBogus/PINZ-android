package com.wsinz.myitems.presentation

import com.wsinz.myitems.adapter.ItemDataHolder

interface MyItemsView {

    fun displayItems(items: List<ItemDataHolder>)
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorDialog(reason: String = "", dismissDialogAction: () -> Unit)
}