package com.wsinz.base.util

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat

class PermissionProviderImpl(private val context: Context) : PermissionProvider {

    override fun checkPermission(permission: String): Boolean =
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}