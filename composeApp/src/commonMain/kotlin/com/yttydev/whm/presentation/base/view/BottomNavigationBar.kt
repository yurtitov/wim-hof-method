package com.yttydev.whm.presentation.base.view

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yttydev.whm.navigation.Destination
import com.yttydev.whm.navigation.TopLevelRoute

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val topLevelRoutes = listOf(
        TopLevelRoute(
            name = "Exercises",
            destination = Destination.ExercisesScreen,
            icon = Icons.Outlined.AccountBox
        ),
        TopLevelRoute(
            name = "Statistics",
            destination = Destination.StatisticsScreen,
            icon = Icons.Outlined.Info
        ),
        TopLevelRoute(
            name = "Profile",
            destination = Destination.ProfileScreen,
            icon = Icons.Outlined.Person
        ),
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        topLevelRoutes.forEach { topLevelRoute ->
            BottomNavigationItem(
                icon = { Icon(topLevelRoute.icon, contentDescription = topLevelRoute.name) },
                label = { Text(topLevelRoute.name) },
                selected = currentDestination?.hierarchy?.any { it.hasRoute(topLevelRoute.destination.fullRoute::class) } == true,
                onClick = {
                    navController.navigate(topLevelRoute.destination.fullRoute) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}