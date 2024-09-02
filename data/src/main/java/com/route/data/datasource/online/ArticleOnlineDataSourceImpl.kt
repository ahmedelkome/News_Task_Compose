package com.route.data.datasource.online

import com.route.data.api.WebService
import com.route.data.contract.online.ArticleOnlineDataSource
import com.route.data.utils.safeData
import com.route.domain.model.Article
import javax.inject.Inject

class ArticleOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService
) : ArticleOnlineDataSource {
    override suspend fun getNewsByCategory(category: String): List<Article> {
        return safeData {
            val listOfNews =
                webService.getNewsByCategory(category).articleDTo?.filterNotNull()!!.map {
                    it.toArticle()
                }
            listOfNews
        }
    }
}