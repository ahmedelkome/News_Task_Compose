package com.route.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.route.domain.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArticle(listOfArticle: List<Article>)


    @Query("SELECT * FROM Article_Table WHERE category = :category")
    suspend fun getAllArticle(category:String): List<Article>

    @Query("DELETE FROM Article_Table")
    suspend fun clearList()
}