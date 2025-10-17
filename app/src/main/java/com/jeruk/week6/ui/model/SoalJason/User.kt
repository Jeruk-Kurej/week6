package com.jeruk.week6.ui.model.SoalJason

import androidx.compose.ui.graphics.vector.ImageVector

data class User(
    val name: String,
    val age: Int,
    val height: Int,
    val weight: Int,
    val iconResId: ImageVector,
    val isFriend: Boolean,
    val workoutCount: Int,
    val friendCount: Int
)