package com.route.news_task_compose.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.route.news_task_compose.home.HomeScreen
import com.route.news_task_compose.navigation.screens.Screens
import com.route.news_task_compose.splash.splashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) {
            splashScreen(navController = navController)
        }
        composable(route = Screens.HomeScreen.route){
            HomeScreen()
        }
    }
}