package com.yttydev.whm.presentation.exercises

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yttydev.whm.navigation.AppNavigator
import com.yttydev.whm.navigation.Destination
import kotlinx.coroutines.launch

class ExercisesViewModel(
    private val appNavigator: AppNavigator
) : ViewModel() {

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

    fun onNavigateToProfile() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ProfileScreen.fullRoute)
        }
    }
}