package com.winthan.organize

import com.winthan.organize.data.DatabaseHelper
import com.winthan.organize.data.RemindersRepository
import com.winthan.organize.presentation.AboutViewModel
import com.winthan.organize.presentation.ReminderViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

object Modules {
    val core = module {
        factory { Platform() }
        factory { DatabaseHelper(get()) }
    }

    val repositories = module {
        factory { RemindersRepository(get()) }
        factory { AboutViewModel(get(), get()) }
    }

    val viewModels = module {
        factory { ReminderViewModel(get()) }
    }
}

fun initKoin(
    appModule: Module = module { },
    coreModule: Module = Modules.core,
    repositoriesModule: Module = Modules.repositories,
    viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
    modules(
        appModule,
        coreModule,
        repositoriesModule,
        viewModelsModule,
        platformModule
    )
}