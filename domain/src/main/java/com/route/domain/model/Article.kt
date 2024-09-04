package com.route.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Article_Table")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "Title")
    val title: String?,
    @ColumnInfo(name = "Description")
    val description: String?,
    @ColumnInfo(name = "URL")
    val url: String?,
    @ColumnInfo(name = "URL Image")
    val urlImage: String?,
    @ColumnInfo(name = "Publish At")
    val publishAt: String?,
    @ColumnInfo(name = "Content")
    val content: String?
) : Parcelable {
}