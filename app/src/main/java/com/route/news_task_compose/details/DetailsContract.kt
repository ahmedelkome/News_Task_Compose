package com.route.news_task_compose.details

import kotlinx.coroutines.flow.SharedFlow


class DetailsContract {
    interface DetailsViewModel {
         fun doAction(action: DetailsAction)
        val event: SharedFlow<DetailsEvents>
    }

    sealed class DetailsAction {
        data class Open(val link: String) : DetailsAction()
        data class Share(val shareArticle: String) : DetailsAction()
    }

    sealed class DetailsEvents {
        data object DetailsIdle:DetailsEvents()
        data class OpenLink(val link: String) : DetailsEvents()
        data class ShareArticle(val shareArticle: String) : DetailsEvents()
    }


}