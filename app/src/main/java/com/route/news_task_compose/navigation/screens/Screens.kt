package com.route.news_task_compose.navigation.screens

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash")
    data object HomeScreen : Screens("home")
    data object DetailsScreen : Screens("details")

    fun withArgs(vararg args: String?): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }

    }
}