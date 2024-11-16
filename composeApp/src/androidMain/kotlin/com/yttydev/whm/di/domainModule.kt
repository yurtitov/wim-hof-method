package com.yttydev.whm.di

import com.yttydev.whm.domain.interactor.PracticeInteractor
import org.koin.dsl.module

val domainModule = module {
    factory {
        PracticeInteractor(practiceRepository = get())
    }
}
