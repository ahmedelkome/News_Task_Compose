package com.route.news_task_compose.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()){
        Text(text = "Hello Home")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun homePrev() {
    HomeScreen()
}