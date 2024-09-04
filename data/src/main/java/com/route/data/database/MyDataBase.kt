package com.route.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.route.domain.model.Article

@Database(entities = [Article::class], version = 1)
abstract class MyDataBase :RoomDatabase(){
    abstract fun articleDao():ArticleDao
}