package com.route.data.model

import com.google.gson.annotations.SerializedName

data class GeneralResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articleDTos: List<ArticleDTo?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)