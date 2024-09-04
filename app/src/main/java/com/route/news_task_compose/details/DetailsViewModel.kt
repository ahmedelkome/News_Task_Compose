package com.route.news_task_compose.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DetailsViewModel() : ViewModel(), DetailsContract.DetailsViewModel {

    private val _event =
        MutableLiveData<DetailsContract.DetailsEvents>(DetailsContract.DetailsEvents.DetailsIdle)
    override val event: LiveData<DetailsContract.DetailsEvents> get() = _event
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
        _event.value = DetailsContract.DetailsEvents.ShareArticle(shareArticle)
    }

    private fun openLink(link: String) {
        _event.value = DetailsContract.DetailsEvents.OpenLink(link)
    }


}