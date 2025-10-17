package com.jeruk.week6.ui.view.SoalJason

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FriendPageView(
    modifier: Modifier = Modifier,
    viewModel: Soal2ViewModel = viewModel()
) {

    val friends by viewModel.friends.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(
            24.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically)
    ) {
        items(friends) {
            FriendCardView(
                user = it,
                toggleIsAdded = { viewModel.toggleIsAdded(it) },
                showAddFriendButton = true
            )
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun FriendPagePreview() {
    FriendPageView()
}