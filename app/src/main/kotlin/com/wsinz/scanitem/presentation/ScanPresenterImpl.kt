package com.wsinz.scanitem.presentation

class ScanPresenterImpl : ScanPresenter<ScanView> {

    var view: ScanView? = null

    override fun attach(view: ScanView) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun validateScannedData(data: String) {

    }
}