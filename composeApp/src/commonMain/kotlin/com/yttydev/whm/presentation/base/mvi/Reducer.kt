package com.yttydev.whm.presentation.base.mvi

fun interface Reducer<State : ViewState, Event : ViewEvent, Effect : ViewEffect> {
    suspend fun reduce(event: Event): Pair<State, Effect?>
}