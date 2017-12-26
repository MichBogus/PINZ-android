package com.wsinz.base.util

import android.content.Context

class StringProviderImpl(private val context: Context) : StringProvider {

    override fun getString(id: Int): String = context.getString(id)
}