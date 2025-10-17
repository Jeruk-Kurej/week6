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
import androidx.compose.material3.Icon
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
import com.jeruk.week6.ui.model.SoalJason.User
import com.jeruk.week6.ui.model.SoalJason.UserDataResource

@Composable
//ini milik Bryan Carlie Lukito Setiawan (no fek fek)
fun ProfileCardView(
    user: User,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8F3FD)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = user.iconResId,
            contentDescription = "person",
            modifier = modifier
                .padding(start = 12.dp)
                .clip(CircleShape)
                .background(Color(0xFFA9D0F8))
                .padding(12.dp)
                .size(60.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "${user.name}, ${user.age}",
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp
            )
            Text(
                "${user.height}cm / ${user.weight}kg",
                fontWeight = FontWeight.ExtraLight,
                fontSize = 15.sp
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "🔥 ${user.workoutCount}",
                    color = Color.Red,
                    fontSize = 18.sp
                )
                Text(
                    "👥 ${user.friendCount}",
                    color = Color.Blue,
                    fontSize = 18.sp
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ProfileCardPreview() {
    ProfileCardView(user = UserDataResource.user)
}