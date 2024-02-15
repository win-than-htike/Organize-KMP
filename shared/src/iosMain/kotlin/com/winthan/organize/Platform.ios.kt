package com.winthan.organize

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.CoreGraphics.CGRectGetHeight
import platform.CoreGraphics.CGRectGetWidth
import platform.Foundation.NSLog
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithCString
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.posix.uname
import platform.posix.utsname
import kotlin.experimental.ExperimentalNativeApi

@OptIn(
    ExperimentalNativeApi::class, ExperimentalForeignApi::class
)
actual class Platform actual constructor() {
    actual val osName: String
        get() = when (UIDevice.currentDevice.userInterfaceIdiom()) {
            UIUserInterfaceIdiomPhone -> "iOS"
            UIUserInterfaceIdiomPad -> "iPadOS"
            else -> kotlin.native.Platform.osFamily.name
        }
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() {
            memScoped {
                val systemInfo: utsname = alloc()
                uname(systemInfo.ptr)
                return NSString.stringWithCString(systemInfo.machine, encoding = NSUTF8StringEncoding)
                    ?: "---"
            }
        }
    actual val cpuType: String
        get() = kotlin.native.Platform.cpuArchitecture.name
    actual val screen: ScreenInfo
        get() = ScreenInfo()

    actual fun logSystemInfo() {
        NSLog(
            deviceInfo
        )
    }

}

@OptIn(ExperimentalForeignApi::class)
actual class ScreenInfo actual constructor() {
    actual val width: Int
        get() = CGRectGetWidth(
            UIScreen.mainScreen.nativeBounds
        ).toInt()
    actual val height: Int
        get() = CGRectGetHeight(
            UIScreen.mainScreen.nativeBounds
        ).toInt()
    actual val density: Int?
        get() = UIScreen.mainScreen.scale.toInt()
}