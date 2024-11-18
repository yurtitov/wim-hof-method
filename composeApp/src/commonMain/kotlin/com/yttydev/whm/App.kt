package com.yttydev.whm

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.yttydev.whm.di.koinConfig
import com.yttydev.whm.presentation.navigation.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = koinConfig
    ) {
        val navController = rememberNavController()
        MaterialTheme {
            AppNavHost(navController)
        }
    }
}