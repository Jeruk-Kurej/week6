package com.jeruk.week6.ui.view.SoalAaron

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationAdd
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jeruk.week6.R
import com.jeruk.week6.ui.viewmodel.Soal1ViewModel

@Composable
fun FoodDeliveryActivity(
    modifier: Modifier = Modifier,
    viewModel: Soal1ViewModel = viewModel()
) {

    var searchInput by rememberSaveable { mutableStateOf("") }
    val foods by viewModel.foods.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier
                    .weight(0.5f)
            ) {
                Spacer(modifier = modifier.height(64.dp))
                Text(
                    "Find Your Favorite Food",
                    fontSize = 24.sp
                )
            }
            Column(
                modifier = modifier
                    .weight(0.5f),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(R.drawable._f1851bb417fc47de5302aef3b90942d38e703e1),
                    contentDescription = "Image",
                    modifier = modifier
                        .size(136.dp)
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchInput,
                onValueChange = { searchInput = it },
                placeholder = {
                    Text(
                        "Search for Food",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Tune,
                        contentDescription = "Tune",
                        tint = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color(0xFFBE438E),
                    unfocusedContainerColor = Color(0xFFBE438E)
                ),
                modifier = modifier
                    .width(320.dp)
                    .clip(RoundedCornerShape(76.dp))
            )
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notif",
                tint = Color(0xFFD93C78),
                modifier = modifier
                    .size(36.dp)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFFD93C78))
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier
                    .weight(0.5f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Special Deal For December",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Buy Now",
                    color = Color(0xFFDB4D84),
                    modifier = modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.White)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable._32735e0948cf9e24d765957e7abf066f2620539),
                contentDescription = "Image",
                modifier = modifier
                    .size(136.dp)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Popular Menu",
                fontWeight = FontWeight.Bold
            )
            Text(
                "View More",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(foods) {
                FoodCardView(food = it)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun FoodDeliveryActivityPreview() {
    FoodDeliveryActivity()
}