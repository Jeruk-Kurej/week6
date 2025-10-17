package com.jeruk.week6.ui.view.SoalAaron

import android.net.RouteInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jeruk.week6.R
import com.jeruk.week6.ui.viewmodel.Soal1ViewModel

@Composable
fun PandamartActivity(
    modifier: Modifier = Modifier,
    viewModel: Soal1ViewModel = viewModel()
) {

    var searchInput by rememberSaveable { mutableStateOf("") }
    val vegetables by viewModel.vegetables.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
            .padding(horizontal = 21.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            "Find Your",
            fontSize = 24.sp
        )
        Text(
            "Favorite Vegetables",
            fontSize = 24.sp
        )
        OutlinedTextField(
            value = searchInput,
            onValueChange = { searchInput = it },
            placeholder = {
                Text(
                    "Search for Vegetables",
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
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color(0xFFBE438E),
                unfocusedContainerColor = Color(0xFFBE438E)
            ),
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(76.dp))
        )
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Featureds Product",
                fontWeight = FontWeight.Bold
            )
            Text(
                "View More",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(vegetables) {
                FoodCardView(food = it)
            }
        }
        Box {
            Image(
                painter = painterResource(id = R.drawable._3ce81b227e955ca1a2ebef66188dbfd672174f6),
                contentDescription = "Panda Icon",
                modifier = Modifier
                    .size(350.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Text(
                text = "20% off on your\nfirst purchase",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 97.dp, top = 155.dp)
            )
            Row(
                modifier = Modifier
                    .padding(start = 90.dp, top = 216.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp, 6.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF8BC34A))
                )
                Spacer(modifier = Modifier.width(8.dp))
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.White)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun PandamartActivityPreview() {
    PandamartActivity()
}