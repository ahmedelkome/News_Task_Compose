package com.route.news_task_compose.details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.domain.model.Article
import com.route.news_task_compose.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(navController: NavController, modifier: Modifier = Modifier) {
    val article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
    article?.let {
        Box(
            modifier = modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            ) {
                Spacer(modifier = modifier.height(30.dp))
                GlideImage(
                    contentScale = ContentScale.FillBounds,
                    modifier = modifier.size(width = 450.dp, height = 250.dp),
                    model = article.urlImage,
                    contentDescription = "Details Image"
                )
                Text(
                    text = article.title!!,
                    fontSize = 18.sp,
                    modifier = modifier.padding(horizontal = 0.dp, vertical = 10.dp)
                )
                Text(
                    text = article.description!!,
                    fontSize = 18.sp,
                    modifier = modifier.padding(0.dp, vertical = 10.dp),
                )
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    onClick = { }) {
                    Text(text = "Share", color = Color.White)
                }
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    onClick = { }) {
                    Text(text = "Open Link", color = Color.White)
                }
            }

        }
    }


    Log.e("TAG", "DetailsScreen: $article")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailsPrev() {
    DetailsScreen(navController = rememberNavController())
}