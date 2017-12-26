package com.wsinz.base.util

import android.support.annotation.StringRes

interface StringProvider {

    fun getString(@StringRes id: Int): String
}