package com.wsinz.scanitem.presentation

interface ScanPresenter<PresenterView> {

    fun attach(view: PresenterView)
    fun detach()

    fun validateScannedData(data: String)
}