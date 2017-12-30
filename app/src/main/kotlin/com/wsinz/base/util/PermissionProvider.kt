package com.wsinz.base.util

import android.Manifest

interface PermissionProvider {

    companion object {
        val CAMERA_PERMISSION = Manifest.permission.CAMERA
        val CAMERA_PERMISSION_CODE = 1000
    }

    fun checkPermission(permission: String): Boolean
}