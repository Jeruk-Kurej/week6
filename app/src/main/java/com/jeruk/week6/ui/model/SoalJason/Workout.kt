package com.jeruk.week6.ui.model.SoalJason

import androidx.compose.ui.graphics.vector.ImageVector

data class Workout(
    val name: String,
    val description: String,
    val caloriesBurned: Int,
    val iconResId: ImageVector,
    val isAdded: Boolean
)