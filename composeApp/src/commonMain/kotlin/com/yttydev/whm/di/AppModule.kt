package com.yttydev.whm.di

import com.yttydev.whm.presentation.practice.PracticeViewModel
import com.yttydev.whm.presentation.statistics.StatisticsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.koinConfiguration
import org.koin.dsl.module


expect fun nativeConfig(): KoinAppDeclaration

val koinConfig = koinConfiguration {
    includes(nativeConfig())
    modules(appModule)
}

val appModule = module {
    viewModelOf(::PracticeViewModel)
    viewModelOf(::StatisticsViewModel)
}