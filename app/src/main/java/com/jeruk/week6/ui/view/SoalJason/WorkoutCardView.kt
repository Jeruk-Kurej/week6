package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeruk.week6.ui.model.SoalJason.Workout

@Composable
// ini milik Bryan Carlie Lukito Setiawan (no fek fek)
fun WorkoutCardView(
    wo: Workout,
    modifier: Modifier = Modifier,
    toggleIsAddedWO: () -> Unit = {},
    showAddWorkoutButton: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFEDF9EF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = wo.iconResId,
            contentDescription = "olahraga dulu dek",
            modifier = modifier
                .padding(start = 12.dp)
                .clip(CircleShape)
                .background(Color(0xFFBCE6C2))
                .padding(12.dp)
                .size(60.dp)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "${wo.name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp
                )
                Text(
                    "${wo.description}",
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp
                )
            }

            if (showAddWorkoutButton)
            IconButton(
                onClick = toggleIsAddedWO
            ) {
                Icon(
                    imageVector =
                        if (wo.isAdded)
                            Icons.Filled.RemoveCircle
                        else
                            Icons.Filled.AddCircle,
                    contentDescription = "add dulu dek",
                    tint = Color(
                        if (wo.isAdded)
                            0xFFEB4C46
                        else
                            0xFF3B86F7
                    ),
                    modifier = modifier
                        .size(40.dp)
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun WorkoutCardPreview() {
    WorkoutCardView(
        wo = Workout(
            name = "Sample Workout",
            description = "Cardio",
            caloriesBurned = 200,
            iconResId = Icons.Filled.AddCircle,
            isAdded = false
        )
    )
}