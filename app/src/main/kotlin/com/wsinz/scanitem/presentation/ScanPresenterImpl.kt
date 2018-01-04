package com.wsinz.scanitem.presentation

import com.google.gson.Gson
import com.wsinz.network.base.AppWSErrorThrowable
import com.wsinz.network.base.NetworkScheduler
import com.wsinz.network.items.model.AddItemBody
import com.wsinz.scanitem.domain.AddItemService
import io.reactivex.functions.Consumer
import org.joda.time.DateTime

class ScanPresenterImpl(private val addItemService: AddItemService,
                        private val networkScheduler: NetworkScheduler) : ScanPresenter<ScanView> {

    var view: ScanView? = null

    override fun attach(view: ScanView) {
        this.view = view
    }

    override fun detach() {
        networkScheduler.disposeAll()
        view = null
    }

    override fun addScannedItem(data: String) {
        try {
            val itemToBeAdded: AddItemBody = Gson().fromJson(data, AddItemBody::class.java)

            if (itemToBeAdded.isEmpty()) {
                view?.hideProgressDialog()
                view?.showItemScannedError()
                return
            }

            itemToBeAdded.dateOfAddition = DateTime.now().toString("dd-MM-yyyy")

            view?.showProgressDialog()
            networkScheduler.schedule(addItemService.addItem(itemToBeAdded),
                    Consumer { onAddItemSuccess() },
                    Consumer { onAddItemFail(it) })
        } catch (ex: Exception) {
            view?.showItemScannedError()
        }
    }

    private fun onAddItemSuccess() {
        view?.hideProgressDialog()
        view?.showSuccessDialog()
    }

    private fun onAddItemFail(throwable: Throwable) {
        view?.hideProgressDialog()

        if (throwable is AppWSErrorThrowable) {
            view?.showErrorDialog(throwable.error?.reason!!, { view?.startCamera() })
        } else {
            view?.showErrorDialog { view?.startCamera() }
        }
    }
}