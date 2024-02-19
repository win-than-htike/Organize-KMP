package com.winthan.organize

import com.winthan.organize.data.RemindersRepository
import com.winthan.organize.presentation.ReminderViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val repositories = module {
        factory { RemindersRepository() }
    }

    val viewModels = module {
        factory { ReminderViewModel(repository = get()) }
    }
}

fun initKoin(
    appModule: Module = module {  },
    repositoriesModule: Module = Modules.repositories,
    viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
    modules(
        appModule,
        repositoriesModule,
        viewModelsModule
    )
}