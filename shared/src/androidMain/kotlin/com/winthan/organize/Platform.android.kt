package com.winthan.organize

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform actual constructor() {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val cpuType: String
        get() = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown"
    actual val screen: ScreenInfo
        get() = ScreenInfo()

    actual fun logSystemInfo() {
        Log.d(
            "Platform",
            deviceInfo
        )
    }

}

actual class ScreenInfo actual constructor() {
    private val metrics = Resources.getSystem().displayMetrics

    actual val width: Int
        get() = metrics.widthPixels
    actual val height: Int
        get() = metrics.heightPixels
    actual val density: Int?
        get() = round(metrics.density).toInt()
}