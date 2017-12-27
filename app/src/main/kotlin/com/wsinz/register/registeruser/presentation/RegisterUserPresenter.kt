package com.wsinz.register.registeruser.presentation

import com.wsinz.network.register.model.RegisterUserBody

interface RegisterUserPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()

    fun register(body: RegisterUserBody)
}