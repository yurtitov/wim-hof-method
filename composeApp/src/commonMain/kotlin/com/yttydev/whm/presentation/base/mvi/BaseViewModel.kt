package com.yttydev.whm.presentation.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : ViewState, Event : ViewEvent, Effect : ViewEffect>(
    initialState: State,
) : ViewModel(), Reducer<State, Event, Effect>, Finalizer<Effect> {

    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State>
        get() = _state.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event: SharedFlow<Event>
        get() = _event.asSharedFlow()

    private val _effect: Channel<Effect> = Channel(capacity = Channel.CONFLATED)
    val effect: Flow<Effect> = _effect.receiveAsFlow()

    val timeMachine: TimeMachine<State> = TimeMachineImpl { storedState ->
        _state.tryEmit(storedState)
    }

    init {
        timeMachine.addState(initialState)

        viewModelScope.launch {
            effect.collect(::finalize)
        }
    }

    protected suspend fun lastState(): State {
        return state.first()
    }

    fun sendEffect(effect: Effect) {
        _effect.trySend(effect)
    }

    fun sendEvent(event: Event) {
        viewModelScope.launch {
            val (newState, effect) = this@BaseViewModel.reduce(event)
            val success = _state.tryEmit(newState)

            if (success) {
                timeMachine.addState(newState)
            }

            effect?.let(::sendEffect)
        }
    }
}