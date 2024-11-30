package com.yttydev.whm.presentation.exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ExercisesScreen(
    stateFlow: StateFlow<ExercisesViewModel.State>,
    onEvent: (event: ExercisesViewModel.Event) -> Unit
) {
    val state by stateFlow.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (state.isBreathButtonVisible) {
                StartButton(
                    text = "Breathing",
                    onClick = { onEvent(ExercisesViewModel.Event.BreathButtonClicked) })
            }
            StartButton(text = "Cold shower")
            StartButton(text = "Explore exercises")
        }
    }

}

@Composable
private fun StartButton(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        elevation = ButtonDefaults.elevation(),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp)
        )
    }
}
