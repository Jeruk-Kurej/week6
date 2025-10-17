package com.jeruk.week6.ui.view.SoalAaron

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeruk.week6.R
import com.jeruk.week6.ui.model.SoalAaron.Food
import com.jeruk.week6.ui.model.SoalAaron.FoodDataResource

@Composable
fun FoodCardView(
    modifier: Modifier = Modifier,
    food: Food
) {
    Column(
        modifier = modifier
            .width(120.dp)
            .height(150.dp)
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(food.imageResId),
            contentDescription = "Image",
            modifier = modifier
                .size(74.dp)
        )
        Text(
            food.name,
            fontWeight = FontWeight.Bold
        )
        Text(
            "$${food.price}",
            color = Color(0xFFD93C78)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun FoodCardPreview() {
    FoodCardView(food = FoodDataResource.foodList[0])
}