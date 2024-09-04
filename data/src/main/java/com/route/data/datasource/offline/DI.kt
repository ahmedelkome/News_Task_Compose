package com.route.data.datasource.offline

import com.route.data.contract.offline.ArticleOfflineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DI {

    @Binds
    abstract fun bindArticleOfflineDataSource(
        articleOfflineDataSourceImpl: ArticleOfflineDataSourceImpl
    ): ArticleOfflineDataSource
}