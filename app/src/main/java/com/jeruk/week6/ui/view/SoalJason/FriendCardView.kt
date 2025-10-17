package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import kotlin.Boolean

@Composable
//ini milik Bryan Carlie Lukito Setiawan (no fek fek)
fun FriendCardView(
    user: User,
    modifier: Modifier = Modifier,
    toggleIsAdded: () -> Unit = {},
    showAddFriendButton: Boolean = true
) {
    Column(
        modifier = modifier
            .width(170.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8F7FB)),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(6.dp))
        Icon(
            imageVector = user.iconResId,
            contentDescription = "person",
            modifier = modifier
                .clip(CircleShape)
                .background(Color(0xFFADE3F2))
                .padding(12.dp)
                .size(60.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "${user.name}",
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp
            )
            Text(
                "${user.age} years old",
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )

            if (showAddFriendButton)
                Button(
                    onClick = toggleIsAdded,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Row(
                        modifier = modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                if (user.isFriend)
                                    Color(0xFFEB4C46)
                                else
                                    Color(0xFF56BDE4)
                            )
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            if (user.isFriend)
                                "Unfriend"
                            else
                                "Add Friend",
                            color = Color.White,
                        )
                    }
                }

        }
    }
}

@Composable
@Preview(showBackground = true)
private fun FriendCardPreview() {
    FriendCardView(user = UserDataResource.friends[0])
}