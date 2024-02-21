package com.winthan.organize.data

import com.winthan.organize.db.ReminderDb
import com.winthan.organize.domain.Reminder
import com.winthan.organize.domain.UUID

class RemindersRepository(
    private val databaseHelper: DatabaseHelper
) {
    val reminders: List<Reminder>
        get() = databaseHelper.fetchAllItems().map(ReminderDb::map)

    fun createReminder(title: String) {
        databaseHelper.insertReminder(
            id = UUID().toString(),
            title = title,
        )
    }

    fun markReminder(id: String, isCompleted: Boolean) {
        databaseHelper.updateIsCompleted(id, isCompleted)
    }
}

fun ReminderDb.map() = Reminder(
    id = this.id,
    title = this.title,
    isCompleted = this.isCompleted(),
)