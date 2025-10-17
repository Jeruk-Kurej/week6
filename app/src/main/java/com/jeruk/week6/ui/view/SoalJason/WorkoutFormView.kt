package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jeruk.week6.ui.model.SoalJason.Workout

@Composable
fun WorkoutFormView(
    modifier: Modifier = Modifier,
    onSave: (title: String, type: String, calories: String, icon: ImageVector) -> Unit,
    onCancel: () -> Unit
) {

    var workoutTitle by remember { mutableStateOf("") }
    var workoutType by remember { mutableStateOf("") }
    var caloriesBurned by remember { mutableStateOf("") }

    var titleError by remember { mutableStateOf(false) }
    var typeError by remember { mutableStateOf(false) }
    var caloriesError by remember { mutableStateOf(false) }

    val icons = listOf(
        Icons.Default.LocalFireDepartment,
        Icons.Default.Favorite,
        Icons.Default.FlashOn,
        Icons.Default.DirectionsRun,
        Icons.Default.School
    )
    var selectedIcon by remember { mutableStateOf(icons.first()) }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Add Workout",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    20.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        "Workout Title",
                        color = Color.Gray
                    )
                    OutlinedTextField(
                        value = workoutTitle,
                        onValueChange = {
                            workoutTitle = it
                            titleError = false
                        },
                        isError = titleError,
                        placeholder = {
                            Text(
                                "e.g. Morning Run",
                                color = Color.LightGray
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color(0xFFF0F0F0),
                            unfocusedContainerColor = Color(0xFFF0F0F0)
                        ),
                        singleLine = true
                    )
                    if (titleError) {
                        Text("Title is required", color = Color.Red, fontSize = 12.sp)
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        "Type",
                        color = Color.Gray
                    )
                    OutlinedTextField(
                        value = workoutType,
                        onValueChange = {
                            workoutType = it
                            typeError = false
                        },
                        isError = typeError,
                        placeholder = {
                            Text(
                                "e.g. Cardio, Strength",
                                color = Color.LightGray
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color(0xFFF0F0F0),
                            unfocusedContainerColor = Color(0xFFF0F0F0)
                        ),
                        singleLine = true
                    )
                    if (typeError) {
                        Text("Type is required", color = Color.Red, fontSize = 12.sp)
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        "Calories Burned",
                        color = Color.Gray
                    )
                    OutlinedTextField(
                        value = caloriesBurned,
                        onValueChange = {
                            caloriesBurned = it
                            caloriesError = false
                        },
                        isError = caloriesError,
                        placeholder = {
                            Text(
                                "e.g. 200",
                                color = Color.LightGray
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color(0xFFF0F0F0),
                            unfocusedContainerColor = Color(0xFFF0F0F0)
                        ),
                        singleLine = true
                    )
                    if (caloriesError) {
                        Text("Calories is required", color = Color.Red, fontSize = 12.sp)
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        "Choose Icon",
                        color = Color.Gray
                    )
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        items(icons) {
                            Icon(
                                imageVector = it,
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .size(76.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFF0F0F0))
                                    .padding(16.dp)
                                    .clickable { selectedIcon = it },
                                tint = if (it == selectedIcon) Color(0xFF2196F3) else Color.Gray
                            )
                        }
                    }
                }
                // ^^^ ^^^ ^^^
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        12.dp,
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    Button(
                        onClick = {
                            titleError = workoutTitle.isBlank()
                            typeError = workoutType.isBlank()
                            caloriesError = caloriesBurned.isBlank()
                            if (!titleError && !typeError && !caloriesError) {
                                onSave(workoutTitle, workoutType, caloriesBurned, selectedIcon)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults
                            .buttonColors(containerColor = Color(0xFF8D8D92))
                    ) {
                        Text(
                            "Save Workout",
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    Button(
                        onClick = onCancel,
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults
                            .buttonColors(containerColor = Color(0xFFE53935))

                    ) {
                        Text(
                            "Cancel",
                            color = Color.White,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun WorkoutFormPreview() {
    WorkoutFormView(
        onSave = { title, type, calories, icon -> },
        onCancel = {}
    )
}