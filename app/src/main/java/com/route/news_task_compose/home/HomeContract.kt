package com.route.news_task_compose.home

import com.route.domain.model.Article
import kotlinx.coroutines.flow.StateFlow

class HomeContract {

    interface HomeViewModel {
        fun doAction(action: Action)

        val state: StateFlow<State>
    }

    sealed class Action {
        data class InitPage (val category:String): Action()
    }


    sealed class State {
        data object Loading : State()
        data class Success(val listOfArticle: List<Article> ) : State()
        data class Failure(val error:String):State()
    }
}