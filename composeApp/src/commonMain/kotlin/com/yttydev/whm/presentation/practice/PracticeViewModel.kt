package com.yttydev.whm.presentation.practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yttydev.whm.navigation.AppNavigator
import com.yttydev.whm.navigation.Destination
import kotlinx.coroutines.launch

class PracticeViewModel(
    private val appNavigator: AppNavigator
) : ViewModel() {

    fun sayHello(): String {
        return "Hello world"
    }

    fun onNavigateToExercises() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ExercisesScreen.fullRoute)
        }
    }

    fun onNavigateToStatistics() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.StatisticsScreen.fullRoute)
        }
    }

    fun onNavigateToProfile() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ProfileScreen.fullRoute)
        }
    }
}