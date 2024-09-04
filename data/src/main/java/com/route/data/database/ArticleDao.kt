package com.route.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.route.domain.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPopular(listOfArticle: List<Article>)


    @Query("SELECT * FROM Article_Table")
    suspend fun getAllArticle(): List<Article>

}