package com.route.data.datasource.offline

import com.route.data.contract.offline.ArticleOfflineDataSource
import com.route.data.database.MyDataBase
import com.route.data.utils.safeData
import com.route.domain.model.Article
import javax.inject.Inject

class ArticleOfflineDataSourceImpl @Inject constructor(
    private val myDataBase: MyDataBase
) : ArticleOfflineDataSource {
    override suspend fun insertArticle(listOfArticle: List<Article>) {
        return safeData {
            myDataBase.articleDao().insertAllArticle(listOfArticle)
        }
    }

    override suspend fun getAllArticle(category:String): List<Article> {
        return safeData {
            val listOfArticle = myDataBase.articleDao().getAllArticle(category = category)
            listOfArticle
        }
    }
}