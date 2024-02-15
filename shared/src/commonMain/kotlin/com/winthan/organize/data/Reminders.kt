package com.winthan.organize.data

data class Reminder(
    val id: String,
    val title: String,
    val isCompleted: Boolean = false,
)