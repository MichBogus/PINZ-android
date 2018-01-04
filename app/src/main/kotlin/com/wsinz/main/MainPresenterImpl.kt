package com.wsinz.main

import com.wsinz.base.AndroidNavigator
import com.wsinz.base.util.PermissionProvider

class MainPresenterImpl(private val androidNavigator: AndroidNavigator,
                        private val permissionProvider: PermissionProvider) : MainPresenter<MainView> {

    var view: MainView? = null

    override fun attach(view: MainView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun itemsList() {
        androidNavigator.openMyItemsActivity()
    }

    override fun scanNewItems() {
        if (permissionProvider.checkPermission(PermissionProvider.CAMERA_PERMISSION)) {
            androidNavigator.openScanItemsActivity()
        } else {
            view?.showPermissionDialog(PermissionProvider.CAMERA_PERMISSION)
        }
    }

    override fun logout() {
        androidNavigator.openLoginActivity()
        view?.closeActivity()
    }
}