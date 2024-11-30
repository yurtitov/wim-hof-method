package com.yttydev.whm.presentation.base.mvi

fun interface Finalizer<Effect : Reducer.ViewEffect> {
    suspend fun finalize(effect: Effect)
}