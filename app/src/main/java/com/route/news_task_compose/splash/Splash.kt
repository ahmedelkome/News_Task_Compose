package com.route.news_task_compose.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.route.news_task_compose.R
import com.route.news_task_compose.navigation.screens.Screens
import kotlinx.coroutines.delay

@Composable
fun splashScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier.size(200.dp)
        )
    }
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        navController.navigate(Screens.HomeScreen.route){
            popUpTo(Screens.SplashScreen.route) { inclusive = true }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun splashPrev() {
    splashScreen(navController = rememberNavController())
}