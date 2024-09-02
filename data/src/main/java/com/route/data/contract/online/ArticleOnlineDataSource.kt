package com.route.data.contract.online

import com.route.domain.model.Article

interface ArticleOnlineDataSource {

    suspend fun getNewsByCategory(category: String): List<Article>
}