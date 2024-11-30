package com.yttydev.whm.presentation.base.mvi

fun interface Reducer<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect> {

    interface ViewState

    interface ViewEvent

    interface ViewEffect

    suspend fun reduce(event: Event): Pair<State, Effect?>
}