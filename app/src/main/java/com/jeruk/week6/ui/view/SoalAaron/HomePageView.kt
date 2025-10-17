package com.jeruk.week6.ui.view.SoalAaron

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jeruk.week6.R
import com.jeruk.week6.ui.route.AppView1
import com.jeruk.week6.ui.viewmodel.Soal1ViewModel

@Composable
fun HomePageView(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {

    var searchInput by rememberSaveable { mutableStateOf("") }
    var selectedTab by rememberSaveable { mutableStateOf("Restaurants") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier
                    .weight(0.5f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Taste the world at your door Step!",
                    fontSize = 24.sp
                )
            }
            Column(
                modifier = modifier
                    .weight(0.5f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ellipse_1),
                    contentDescription = "Image",
                    modifier = modifier
                        .size(48.dp)
                )
            }
        }
        OutlinedTextField(
            value = searchInput,
            onValueChange = { searchInput = it },
            placeholder = {
                Text(
                    "What are you craving?",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },
            leadingIcon = {},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = modifier
                        .padding(end = 21.dp)
                        .size(32.dp)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFBE438E),
                unfocusedContainerColor = Color(0xFFBE438E),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(56.dp)),
        )
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val tabItems = listOf("Restaurants", "Deals", "Track Order")
            tabItems.forEach { tab ->
                val isSelected = selectedTab == tab
                Text(
                    text = tab,
                    color = if (isSelected) Color.White else Color(0xFFC88BB2),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(24.dp))
                        .background(if (isSelected) Color(0xFFC572A7) else Color(0xFFD5C6CF))
                        .clickable { selectedTab = tab }
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MainCardView(
                modifier = modifier
                    .clickable {
                        navController.navigate(
                            "${AppView1.FoodDelivery.name}"
                        )
                    },
                "Food Delivery",
                "Delivery from $99",
                R.drawable.group_21
            )
            MainCardView(
                modifier = modifier
                    .clickable {
                        navController.navigate(
                            "${AppView1.Pandamart.name}"
                        )
                    },
                "Pandamart",
                "New users $10 off",
                R.drawable.group_22
            )
        }
        Column {
        Text(
            "Restaurant Available Now!",
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp
        )
        Image(
            painter = painterResource(R.drawable._6c291cd055c5f81e78ab7999883f0dc80e3af41),
            contentDescription = "Image",
            modifier = modifier
                .size(500.dp)
                .aspectRatio(16f / 9f),
            contentScale = ContentScale.Crop
        )
            }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HomePagePreview() {
    HomePageView()
}