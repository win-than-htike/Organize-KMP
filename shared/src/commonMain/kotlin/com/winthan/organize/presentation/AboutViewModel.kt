package com.winthan.organize.presentation

import com.russhwolf.settings.Settings
import com.winthan.organize.BaseViewModel
import com.winthan.organize.DateFormatter
import com.winthan.organize.Platform
import kotlinx.datetime.Clock
import kotlin.math.max
import kotlin.math.min

class AboutViewModel(
    platform: Platform,
    settings: Settings
) : BaseViewModel(){

    val firstOpening: String

    init {
        val timestampKey = "FIRST_OPENING_TIMESTAMP"

        val savedValue = settings.getLongOrNull(timestampKey)

        firstOpening = if (savedValue == null) {
            val time = Clock.System.now().epochSeconds - 1
            settings.putLong(timestampKey, time)
            DateFormatter.formatEpoch(time)
        } else {
            DateFormatter.formatEpoch(savedValue)
        }
    }

    data class RowItem(
        val title: String,
        val subtitle: String,
    )

    private fun makeRowItems(platform: Platform): List<RowItem> {
        val rowItems = mutableListOf(
            RowItem("Operating System", "${platform.osName} ${platform.osVersion}"),
            RowItem("Device", platform.deviceModel),
            RowItem("CPU", platform.cpuType),
        )
        platform.screen.let {
            rowItems.add(
                RowItem(
                    "Display",
                    "${
                        max(it.width, it.height)
                    }×${
                        min(it.width, it.height)
                    } @${it.density}x"
                ),
            )
        }
        return rowItems
    }

    val items: List<RowItem> = makeRowItems(platform)

}