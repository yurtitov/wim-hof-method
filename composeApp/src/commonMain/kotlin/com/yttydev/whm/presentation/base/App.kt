package com.yttydev.whm.presentation.base

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yttydev.whm.di.koinConfig
import com.yttydev.whm.navigation.Destination
import com.yttydev.whm.navigation.NavHost
import com.yttydev.whm.navigation.NavigationIntent
import com.yttydev.whm.navigation.composable
import com.yttydev.whm.presentation.base.view.BottomNavigationBar
import com.yttydev.whm.presentation.exercises.ExercisesScreen
import com.yttydev.whm.presentation.practice.PracticeScreen
import com.yttydev.whm.presentation.profile.ProfileScreen
import com.yttydev.whm.presentation.statistics.StatisticsScreen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    KoinApplication(
        application = koinConfig
    ) {
        val appViewModel = koinViewModel<AppViewModel>()
        val navController = rememberNavController()

        NavigationEffects(
            navigationChannel = appViewModel.navigationChannel,
            navHostController = navController
        )

        MaterialTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Destination.ExercisesScreen
                ) {
                    composable(destination = Destination.ExercisesScreen) {
                        ExercisesScreen()
                    }
                    composable(destination = Destination.PracticeDetailsScreen) {
                        PracticeScreen()
                    }
                    composable(destination = Destination.StatisticsScreen) {
                        StatisticsScreen()
                    }
                    composable(destination = Destination.ProfileScreen) {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    LaunchedEffect(navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            when (intent) {
                is NavigationIntent.NavigationBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigationUp -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}