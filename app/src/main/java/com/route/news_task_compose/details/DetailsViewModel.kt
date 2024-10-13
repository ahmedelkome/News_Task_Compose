package com.route.news_task_compose.details


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


class DetailsViewModel() : ViewModel(), DetailsContract.DetailsViewModel {

    private val _event = MutableSharedFlow<DetailsContract.DetailsEvents>(replay = 0)
    override val event: SharedFlow<DetailsContract.DetailsEvents> get() = _event
    override fun doAction(action: DetailsContract.DetailsAction) {
        when (action) {
            is DetailsContract.DetailsAction.Open -> {
                openLink(action.link)
            }

            is DetailsContract.DetailsAction.Share -> {
                shareArticle(action.shareArticle)
            }
        }
    }

    private fun shareArticle(shareArticle: String) {
//        _event.value = DetailsContract.DetailsEvents.ShareArticle(shareArticle)
        viewModelScope.launch {
            _event.emit(DetailsContract.DetailsEvents.ShareArticle(shareArticle = shareArticle))
        }

    }

    private fun openLink(link: String) {
//        _event.value = DetailsContract.DetailsEvents.OpenLink(link)
        viewModelScope.launch {
            _event.emit(DetailsContract.DetailsEvents.OpenLink(link))
        }

    }


}