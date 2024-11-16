package com.yttydev.whm.di

import com.yttydev.whm.data.repository.PracticeRepositoryImpl
import com.yttydev.whm.domain.api.PracticeRepository
import org.koin.dsl.module

val dataModule = module {
    single<PracticeRepository> {
        PracticeRepositoryImpl()
    }
}
