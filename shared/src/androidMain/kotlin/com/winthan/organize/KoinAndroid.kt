package com.winthan.organize

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.dsl.module

actual val platformModule = module {
    single<Settings> {
        SharedPreferencesSettings(get())
    }
    single<SqlDriver> {
        AndroidSqliteDriver(OrganizeDb.Schema, get(), "organize.db")
    }
}