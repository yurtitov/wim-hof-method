package com.yttydev.whm.presentation.base.mvi

interface TimeMachine<State : ViewState> {

    fun addState(state: State)

    val storeState: (storedState: State) -> Unit
}