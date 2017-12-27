package com.wsinz.main

import com.wsinz.base.AndroidNavigator

class MainPresenterImpl(private val androidNavigator: AndroidNavigator) : MainPresenter<MainView> {

    var view: MainView? = null

    override fun attach(view: MainView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun itemsList() {

    }

    override fun scanNewItems() {

    }

    override fun logout() {
        androidNavigator.openLoginActivity()
        view?.closeActivity()
    }
}