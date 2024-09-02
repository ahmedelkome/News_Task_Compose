package com.route.data.datasource.online

import com.route.data.contract.online.ArticleOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DI {

    @Binds
    abstract fun bindArticleOnlineDataSource(
        articleOnlineDataSourceImpl: ArticleOnlineDataSourceImpl
    ): ArticleOnlineDataSource
}