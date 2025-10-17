package com.jeruk.week6.ui.view.SoalAaron

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp
import com.jeruk.week6.R
import com.jeruk.week6.ui.model.SoalAaron.Food

@Composable
fun MainCardView(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    image: Int
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        Column(
            modifier = modifier
                .padding(top = 8.dp)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                desc,
                fontSize = 12.sp,
                color = Color(0xFF828282)
            )
        }
        Image(
            painter = painterResource(image),
            contentDescription = "Image",
            modifier = modifier
                .size(176.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MainCardPreview() {
    MainCardView(
        title = "Food Delivery",
        desc = "Delivery from $99",
        image = R.drawable.group_21
    )
}