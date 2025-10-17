package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WorkoutPageView(
    modifier: Modifier = Modifier,
    viewModel: Soal2ViewModel = viewModel()
) {

    val workout by viewModel.workout.collectAsState()
    var showAddWorkoutForm by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize()
        ) {
            items(workout) { workout ->
                WorkoutCardView(
                    wo = workout,
                    toggleIsAddedWO = { viewModel.toggleIsAddedWO(workout) },
                    showAddWorkoutButton = true
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            IconButton(
                onClick = {
                    showAddWorkoutForm = true
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "addButton",
                    modifier = Modifier
                        .size(50.dp),
                    tint = Color.Blue
                )
            }
        }
        if (showAddWorkoutForm) {
            Dialog(
                onDismissRequest = { showAddWorkoutForm = false }
            ) {
                WorkoutFormView(
                    onSave = {  title, type, calories, icon ->
                        viewModel.saveWorkout(title, type, calories, icon)
                        showAddWorkoutForm = false
                    },
                    onCancel = {
                        showAddWorkoutForm = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun WorkoutPagePreview() {
    WorkoutPageView()
}