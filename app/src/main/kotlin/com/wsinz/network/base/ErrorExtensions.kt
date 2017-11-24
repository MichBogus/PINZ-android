package com.wsinz.network.base

import com.google.gson.Gson
import io.reactivex.Single
import retrofit2.HttpException

class AppWSErrorThrowable : Throwable() {

    var error: BaseResponse? = null
    var code: Int = -1
    var messagge: String = ""

    fun create(ex: HttpException): AppWSErrorThrowable {
        code = ex.code()
        messagge = ex.message()
        error = Gson().fromJson(ex.response().errorBody().charStream(), BaseResponse::class.java)

        return this
    }
}

fun <T> Single<T>.withErrorHandling(): Single<T> =
        this.onErrorResumeNext {
            if (it is HttpException) {
                Single.error(AppWSErrorThrowable().create(it))
            } else {
                Single.error(it)
            }
        }

//fun <T> Single<T>.appOnError(throwable: Throwable): Single<T> {
//    return this.
//}