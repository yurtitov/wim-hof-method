package com.yttydev.whm.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.yttydev.whm.domain.interactor.PracticeInteractor

class MainViewModel(
    private val practiceInteractor: PracticeInteractor
) : ViewModel() {
    init {
        Log.i("qqq", "vm: init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("qqq", "vm: onCleared")
    }
}
