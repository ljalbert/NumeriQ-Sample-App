package com.lja.numeriqsampleapp.service.api

import com.lja.numeriqsampleapp.service.model.service.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {

    @GET("everything")
    suspend fun getArticles(
        @Query("q") query: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Response
}