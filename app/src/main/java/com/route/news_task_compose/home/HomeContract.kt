package com.route.news_task_compose.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.route.domain.model.Article
import kotlinx.coroutines.flow.StateFlow

class HomeContract {

    interface HomeViewModel {
        fun doAction(action: Action)

        val state: StateFlow<State>
        val event:LiveData<Events>
    }

    sealed class Action {
        data class InitPage (val category:String): Action()
        data class Navigate(val article: Article):Action()
    }

    sealed class Events{
        data object Idle:Events()
        data class NavigateToDetails(val article: Article):Events()
    }


    sealed class State {
        data object Loading : State()
        data class Success(val listOfArticle: List<Article> ) : State()
        data class Failure(val error:String):State()
    }
}