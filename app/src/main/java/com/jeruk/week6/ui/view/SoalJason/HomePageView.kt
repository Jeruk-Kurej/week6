package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
// ini milik Bryan Carlie Lukito Setiawan (no fek fek)
fun HomePageView(
    modifier: Modifier = Modifier,
    viewModel: Soal2ViewModel = viewModel()
) {

    val user by viewModel.user.collectAsState()
    val addedFriends by viewModel.addedFriends.collectAsState()
    val addedWorkout by viewModel.addedWorkouts.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileCardView(
            user = user
        )
        Text(
            "Recently Added",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        if (addedFriends.isEmpty()) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .width(170.dp)
                    .height(210.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "No Friends yet",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }

        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(addedFriends) {
                    FriendCardView(
                        user = it,
                        toggleIsAdded = { viewModel.toggleIsAdded(it) },
                        showAddFriendButton = false
                    )
                }
            }
        }

        Text(
            "Recent Workouts",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        if (addedWorkout.isEmpty()) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .width(170.dp)
                    .height(210.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "No Workouts yet",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }

        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(addedWorkout) {
                    WorkoutCardView(
                        wo = it,
                        toggleIsAddedWO = { viewModel.toggleIsAddedWO(it) },
                        showAddWorkoutButton = false
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HomePagePreview() {
    HomePageView()
}