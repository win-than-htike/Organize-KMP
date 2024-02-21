package com.winthan.organize.data

import app.cash.sqldelight.db.SqlDriver
import com.winthan.organize.OrganizeDb
import com.winthan.organize.db.ReminderDb

class DatabaseHelper(
    sqlDriver: SqlDriver,
) {
    private val dbRef: OrganizeDb = OrganizeDb(sqlDriver)

    fun fetchAllItems(): List<ReminderDb> =
        dbRef.tableQueries
            .selectAll()
            .executeAsList()

    fun insertReminder(id: String, title: String) {
        dbRef.tableQueries.insertReminder(id, title)
    }

    fun updateIsCompleted(id: String, isCompleted: Boolean) {
        dbRef.tableQueries
            .updateIsCompleted(isCompleted.toLong(), id)
    }
}

fun ReminderDb.isCompleted() = this.isCompleted != 0L

internal fun Boolean.toLong(): Long = if (this) 1L else 0L