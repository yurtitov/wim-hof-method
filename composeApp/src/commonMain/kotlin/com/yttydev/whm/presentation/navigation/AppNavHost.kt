package com.yttydev.whm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yttydev.whm.presentation.practice.PracticeScreen
import com.yttydev.whm.presentation.statistics.StatisticsScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "statistics") {
        composable(route = "practice") {
            PracticeScreen()
        }
        composable(route = "statistics") {
            StatisticsScreen()
        }
    }
}