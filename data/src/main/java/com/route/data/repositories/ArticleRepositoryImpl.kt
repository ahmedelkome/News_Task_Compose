package com.route.data.repositories

import com.route.data.contract.online.ArticleOnlineDataSource
import com.route.domain.common.ResultWrapper
import com.route.domain.model.Article
import com.route.domain.repos.ArticleRepository
import com.route.domain.utils.toFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleOnlineDataSource: ArticleOnlineDataSource
) : ArticleRepository {
    override suspend fun getNewsByCategory(category: String): Flow<ResultWrapper<List<Article>>> {
        return toFlow {
            articleOnlineDataSource.getNewsByCategory(category)
        }
    }
}