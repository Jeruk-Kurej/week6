package com.jeruk.week6.ui.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jeruk.week6.ui.view.SoalAaron.FoodDeliveryActivity
import com.jeruk.week6.ui.view.SoalAaron.HomePageView
import com.jeruk.week6.ui.view.SoalAaron.PandamartActivity
import com.jeruk.week6.ui.viewmodel.Soal1ViewModel

enum class AppView1(
    val title: String,
    val icon: ImageVector? = null
) {
    HomePage("Home"),
    FoodDelivery("Delivery"),
    Pandamart("Vegetables")
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppRouteAaron() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val currentView = AppView1.entries.find { it.name == currentRoute }
    val viewModel: Soal1ViewModel = viewModel()

    Scaffold(
        topBar = {
            MyTopAppBar1(
                currentView = currentView,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },

        ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = AppView1.HomePage.name
        ) {
            composable(route = AppView1.HomePage.name) {
                HomePageView(navController = navController)
            }

            composable(route = AppView1.FoodDelivery.name) {
                FoodDeliveryActivity()
            }

            composable(route = AppView1.Pandamart.name) {
                PandamartActivity()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar1(
    currentView: AppView1?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {

    val isHomePage = currentView == AppView1.HomePage
    val isPandamartPage = currentView == AppView1.Pandamart
    val isFoodDeliveryPage = currentView == AppView1.FoodDelivery

    if (isFoodDeliveryPage) {

    } else {
        CenterAlignedTopAppBar(
            title = {
                if (isPandamartPage)
                    Text(
                        text = currentView?.title ?: AppView1.Pandamart.title,
                        fontSize = 28.sp,
                        color = Color.White
                    )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor =
                    if (!isPandamartPage) {
                        Color(0xFFD9D9D9)
                    } else if (isPandamartPage) {
                        Color(0xFFBE438E)
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
            ),
            modifier = modifier,
            navigationIcon = {
                if (isPandamartPage)
                    if (canNavigateBack) {
                        IconButton(onClick = navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = modifier
                                    .padding(start = 21.dp)
                            )
                        }
                    }
            },
            actions = {
                if(isPandamartPage)
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Keranjang cuyy",
                    tint = Color.White,
                    modifier = modifier
                        .padding(end = 21.dp)
                )
            }
        )
    }
}