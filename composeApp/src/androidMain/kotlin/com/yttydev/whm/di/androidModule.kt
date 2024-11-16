package com.yttydev.whm.di

import com.yttydev.whm.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val androidModule = module {
    viewModelOf(::MainViewModel)
}
