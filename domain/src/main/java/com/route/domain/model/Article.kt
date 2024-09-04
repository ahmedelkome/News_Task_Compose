package com.route.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article (
    val title:String?,
    val description:String?,
    val url:String?,
    val urlImage:String?,
    val publishAt:String?,
    val content:String?
): Parcelable {
}