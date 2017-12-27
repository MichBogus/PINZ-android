package com.wsinz.main

interface MainPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()

    fun itemsList()
    fun scanNewItems()
    fun logout()

}