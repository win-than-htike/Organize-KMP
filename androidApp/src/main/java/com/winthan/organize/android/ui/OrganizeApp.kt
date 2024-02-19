package com.winthan.organize.android.ui

import android.app.Application
import com.winthan.organize.initKoin
import com.winthan.organize.presentation.ReminderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class OrganizeApp : Application(){
    override fun onCreate() {
        super.onCreate()

        initKoin(
            viewModelsModule = module {
                viewModel {
                    ReminderViewModel(repository = get())
                }
            }
        )

    }
}