package com.route.news_task_compose.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.route.news_task_compose.navigation.graph.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Navigation(navController = navController)
        }
    }
}

