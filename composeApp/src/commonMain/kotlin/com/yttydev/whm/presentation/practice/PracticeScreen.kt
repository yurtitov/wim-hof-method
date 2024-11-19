package com.yttydev.whm.presentation.practice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import wimhofmethod.composeapp.generated.resources.Res
import wimhofmethod.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun PracticeScreen() {
    val vm = koinViewModel<PracticeViewModel>()
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Practice screen")

        Button(
            onClick = {
                showContent = !showContent
            }
        ) {
            Text("Goto Statistics")
        }
        AnimatedVisibility(showContent) {
            val greeting = vm.sayHello()
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("Compose: $greeting")
            }
        }

        Button(
            onClick = vm::onNavigateToExercises,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Text("Exercises")
        }

        Button(
            onClick = vm::onNavigateToStatistics,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Text("Statistics")
        }

        Button(
            onClick = vm::onNavigateToProfile,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Text("Profile")
        }
    }
}