package com.winthan.organize.android.ui

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.winthan.organize.initKoin
import com.winthan.organize.presentation.AboutViewModel
import com.winthan.organize.presentation.ReminderViewModel
import org.koin.androidx.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class OrganizeApp : Application(){
    override fun onCreate() {
        super.onCreate()

        initKoin(
            appModule = module {
                single<Context> { this@OrganizeApp }

                single<SharedPreferences> {
                    get<Context>().getSharedPreferences(
                        "OrganizeApp",
                        Context.MODE_PRIVATE
                    )
                }
            },
            viewModelsModule = module {
                viewModel {
                    ReminderViewModel(repository = get())
                }
                viewModel {
                    AboutViewModel(get(), get())
                }
            }
        )

    }
}