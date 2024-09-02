package com.route.domain.usecase

import com.route.domain.common.ResultWrapper
import com.route.domain.model.Article
import com.route.domain.repos.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend fun getNewsByCategory(category: String): Flow<ResultWrapper<List<Article>>> {
        return articleRepository.getNewsByCategory(category = category)
    }
}