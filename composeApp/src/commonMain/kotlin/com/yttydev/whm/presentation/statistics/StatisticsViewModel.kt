package com.yttydev.whm.presentation.statistics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yttydev.whm.navigation.AppNavigator
import com.yttydev.whm.navigation.Destination
import kotlinx.coroutines.launch

class StatisticsViewModel(
    private val appNavigator: AppNavigator
) : ViewModel() {

    fun onNavigateToExercises() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ExercisesScreen.fullRoute)
        }
    }

    fun onNavigateToPractice() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.PracticeDetailsScreen.fullRoute)
        }
    }

    fun onNavigateToProfile() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ProfileScreen.fullRoute)
        }
    }
}