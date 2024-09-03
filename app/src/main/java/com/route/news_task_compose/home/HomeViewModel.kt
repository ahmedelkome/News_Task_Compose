package com.route.news_task_compose.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.common.ResultWrapper
import com.route.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
) : ViewModel(), HomeContract.HomeViewModel {

    private val _state = MutableStateFlow<HomeContract.State>(HomeContract.State.Loading)
    override val state: StateFlow<HomeContract.State> = _state


    override fun doAction(action: HomeContract.Action) {
        when (action) {
            is HomeContract.Action.InitPage -> {
                getNewsByCategory(action.category)
            }
        }
    }


    private fun getNewsByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsUseCase.getNewsByCategory(category).collect {
                when (it) {
                    is ResultWrapper.Success -> {
                        _state.emit(HomeContract.State.Success(it.data))
                    }

                    is ResultWrapper.Failure -> {
                        _state.emit(HomeContract.State.Failure(it.e.localizedMessage))
                    }

                    ResultWrapper.Loading -> {
                        _state.emit(HomeContract.State.Loading)
                    }
                }
            }
        }
    }
}