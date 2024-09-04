package com.route.news_task_compose.details

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.domain.model.Article

@Composable
fun DetailsScreen(navController:NavController,modifier: Modifier = Modifier) {
    val article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
   article?.let {
       Text(text = article.title!!)
   }

    Log.e("TAG", "DetailsScreen: $article", )
}