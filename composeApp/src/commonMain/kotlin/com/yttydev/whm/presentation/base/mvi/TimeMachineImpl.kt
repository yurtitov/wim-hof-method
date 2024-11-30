package com.yttydev.whm.presentation.base.mvi

class TimeMachineImpl<State : Reducer.ViewState>(
    override val storeState: (storedState: State) -> Unit
) : TimeMachine<State> {

    override fun addState(state: State) {
        // TODO
    }
}