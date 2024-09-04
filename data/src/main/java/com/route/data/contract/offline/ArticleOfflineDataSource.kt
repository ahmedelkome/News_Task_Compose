package com.route.data.contract.offline

import com.route.domain.model.Article

interface ArticleOfflineDataSource {
    suspend fun insertArticle(listOfArticle:List<Article>)

    suspend fun getAllArticle():List<Article>
}