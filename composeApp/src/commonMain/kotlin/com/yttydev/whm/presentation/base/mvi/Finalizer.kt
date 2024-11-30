package com.yttydev.whm.presentation.base.mvi

fun interface Finalizer<Effect : ViewEffect> {
    suspend fun finalize(effect: Effect)
}