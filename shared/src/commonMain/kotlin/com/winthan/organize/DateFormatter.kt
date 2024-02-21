package com.winthan.organize

expect object DateFormatter {
    fun formatEpoch(epoch: Long): String
}