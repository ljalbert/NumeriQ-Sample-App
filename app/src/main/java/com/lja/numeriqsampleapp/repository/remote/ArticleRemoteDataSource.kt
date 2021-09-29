package com.lja.numeriqsampleapp.repository.remote

import com.lja.numeriqsampleapp.service.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

interface ArticleRemoteDataSource {
    suspend fun getListArticles(
        query: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): Flow<List<ArticleService>>
}