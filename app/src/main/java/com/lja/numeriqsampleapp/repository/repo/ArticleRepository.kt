package com.lja.numeriqsampleapp.repository.repo

import com.lja.numeriqsampleapp.service.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun getListArticles(
        query: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): Flow<List<ArticleService>>
}