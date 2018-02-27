package com.wsinz.myitems.presentation

interface MyItemsPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()

    fun gatherUserItems()
    fun deleteItem(itemToken: String)
}