package com.yttydev.whm

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.yttydev.whm.presentation.base.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "WimHofMethod",
    ) {
        App()
    }
}