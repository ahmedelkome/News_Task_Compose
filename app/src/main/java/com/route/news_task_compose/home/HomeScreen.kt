package com.route.news_task_compose.home

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.Placeholder
import com.bumptech.glide.integration.compose.placeholder
import com.route.domain.model.Article
import com.route.domain.usecase.GetNewsUseCase
import com.route.news_task_compose.R
import com.route.news_task_compose.model.Category
import com.route.news_task_compose.navigation.screens.Screens
import com.route.news_task_compose.utils.Constants
import com.route.news_task_compose.utils.ErrorDialog
import com.route.news_task_compose.utils.LoadingDialog
import kotlinx.coroutines.flow.MutableStateFlow
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column {
            Spacer(modifier = modifier.height(100.dp))
            listOfCategories(navController = navController)
        }

    }
}

@Composable
fun listOfCategories(
    modifier: Modifier = Modifier,
    list: List<Category> = Constants.LIST_OF_CATEGORIES,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val selectedCategory = remember { mutableStateOf("sports") }
    val event by homeViewModel.event.observeAsState(initial = HomeContract.Events.Idle)
    val state by homeViewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        homeViewModel.doAction(
            HomeContract.Action.InitPage(
                selectedCategory.value
            )
        )
    }
    Column {
        LazyRow {
            items(list.size) { position ->
                Spacer(modifier = modifier.padding(10.dp))
                Column(
                    modifier = modifier.clickable {
                        selectedCategory.value = list[position].name
                        homeViewModel.doAction(HomeContract.Action.InitPage(selectedCategory.value))
                    },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = list[position].image),
                        contentDescription = "categoryImage",
                        contentScale = ContentScale.Crop,
                        modifier = modifier.size(100.dp)
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(text = list[position].name, fontSize = 20.sp)
                    Spacer(modifier = modifier.padding(10.dp))
                }
                Spacer(modifier = modifier.padding(10.dp))
            }
        }
        when (state) {
            is HomeContract.State.Failure -> {
                ErrorDialog(
                    title = "Error",
                    message = (state as HomeContract.State.Failure).error
                ) {

                }
            }

            HomeContract.State.Loading -> {
                LoadingDialog()
            }

            is HomeContract.State.Success -> {
                val listOfArticle = (state as HomeContract.State.Success).listOfArticle
                listOfArticle(
                    list = listOfArticle,
                ) { article, position ->
                    homeViewModel.doAction(HomeContract.Action.Navigate(article = article))
                    Log.e("TAG", "Action do: $article")
                }
            }
        }
        LaunchedEffect(key1 = event) {
            when (event) {
                HomeContract.Events.Idle -> {

                }

                is HomeContract.Events.NavigateToDetails -> {
                    Log.e(
                        "TAG",
                        "eveeeeeeent value: ${(event as HomeContract.Events.NavigateToDetails).article}",
                    )
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "article",
                        (event as HomeContract.Events.NavigateToDetails).article
                    )
                    navController.navigate(Screens.DetailsScreen.route)
                    homeViewModel.setEventToIdle()
                }
            }
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun listOfArticle(
    modifier: Modifier = Modifier,
    list: List<Article>,
    navigate: (article: Article, position: Int) -> Unit
) {
    LazyColumn {
        items(list.size) { position ->
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .clickable {
                        navigate.invoke(list[position], position)
                    }
            ) {
                GlideImage(
                    contentScale = ContentScale.FillBounds,
                    modifier = modifier.fillMaxWidth(),
                    model = list[position].urlImage,
                    contentDescription = "ArticleImage",
                    loading = placeholder(R.drawable.loading)
                )
                Spacer(modifier = modifier.height(5.dp))
                Text(text = list[position].title!!, modifier.padding(10.dp))
                Spacer(modifier = modifier.height(5.dp))
                Text(text = formatDateTime(list[position].publishAt), modifier.padding(10.dp))
            }

        }
    }
}


fun formatDateTime(dateTimeString: String?): String {
    return if (dateTimeString != null) {
        val zonedDateTime = ZonedDateTime.parse(dateTimeString)
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        zonedDateTime.format(formatter)
    } else {
        ""
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun listOfcategory() {
    //
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun homePrev() {

}