package com.route.data.model

import com.google.gson.annotations.SerializedName
import com.route.domain.model.Article

data class ArticleDTo(

    @field:SerializedName("publishedAt")
    val publishedAt: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("source")
    val source: Source? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("content")
    val content: String? = null
) {
    fun toArticle(): Article {
        return Article(
            title = title,
            description = description,
            url = url,
            urlImage = urlToImage,
            publishAt = publishedAt,
            content = content
        )
    }
}