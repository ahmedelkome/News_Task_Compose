package com.route.news_task_compose.utils

import com.route.news_task_compose.R
import com.route.news_task_compose.model.Category

object Constants {
    val LIST_OF_CATEGORIES =
        listOf(
            Category(name = "sports", image = R.drawable.sports),
            Category(name = "science", image = R.drawable.science),
            Category(name = "health", image = R.drawable.health),
            Category(name = "business", image = R.drawable.business),
            Category(name = "entertainment", image = R.drawable.entertainment),
            Category(name = "general", image = R.drawable.general),
            Category(name = "technology", image = R.drawable.technology),
        )
}