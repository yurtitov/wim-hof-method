package com.yttydev.whm.presentation.base.mvi

interface TimeMachine<State : Reducer.ViewState> {

    fun addState(state: State)

    val storeState: (storedState: State) -> Unit
}