package com.yttydev.whm.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yttydev.whm.navigation.AppNavigator
import com.yttydev.whm.navigation.Destination
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val appNavigator: AppNavigator
): ViewModel() {

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

    fun onNavigateToStatistics() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.StatisticsScreen.fullRoute)
        }
    }
}