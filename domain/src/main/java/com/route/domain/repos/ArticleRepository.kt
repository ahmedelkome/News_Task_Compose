package com.route.domain.repos

import com.route.domain.common.ResultWrapper
import com.route.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getNewsByCategory(category: String): Flow<ResultWrapper<List<Article>>>
}