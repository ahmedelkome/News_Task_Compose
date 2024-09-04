package com.route.data.api

import com.route.data.model.GeneralResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("top-headlines/category/{category}/us.json")
    suspend fun getNewsByCategory(
        @Path("category") category: String
    ): GeneralResponse
}