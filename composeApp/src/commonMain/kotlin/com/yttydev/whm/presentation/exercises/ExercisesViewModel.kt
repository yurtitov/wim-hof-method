package com.yttydev.whm.presentation.exercises

import com.yttydev.whm.navigation.AppNavigator
import com.yttydev.whm.navigation.Destination
import com.yttydev.whm.presentation.base.mvi.BaseViewModel
import com.yttydev.whm.presentation.base.mvi.Reducer

class ExercisesViewModel(
    private val appNavigator: AppNavigator
) : BaseViewModel<ExercisesViewModel.State, ExercisesViewModel.Event, ExercisesViewModel.Effect>(
    State()
) {

    override suspend fun reduce(event: Event): Pair<State, Effect?> {
        return when (event) {
            is Event.BreathButtonClicked -> onBreathButtonClicked()
        }
    }

    override suspend fun finalize(effect: Effect) {
        when (effect) {
            is Effect.NavigateToBreathPractice -> appNavigator.navigateTo(
                Destination.PracticeDetailsScreen.fullRoute
            )
        }
    }

    private suspend fun onBreathButtonClicked(): Pair<State, Effect?> {
        lastState().let { lastState ->
            return lastState.copy() to Effect.NavigateToBreathPractice
        }
    }

    data class State(
        val isBreathButtonVisible: Boolean = true,
    ) : Reducer.ViewState

    sealed class Event : Reducer.ViewEvent {
        data object BreathButtonClicked : Event()
    }

    sealed class Effect : Reducer.ViewEffect {
        data object NavigateToBreathPractice : Effect()
    }
}