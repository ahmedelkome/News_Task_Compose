package com.route.news_task_compose.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.route.domain.model.Article
import com.route.news_task_compose.details.DetailsScreen
import com.route.news_task_compose.home.HomeScreen
import com.route.news_task_compose.navigation.screens.Screens
import com.route.news_task_compose.splash.splashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) {
            splashScreen(navController = navController)
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.DetailsScreen.route,) { backStackEntry ->
            DetailsScreen(navController=navController)
        }
    }
}