package com.yttydev.whm

import androidx.lifecycle.ViewModel
import com.yttydev.whm.navigation.AppNavigator

class AppViewModel(appNavigator: AppNavigator) : ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}