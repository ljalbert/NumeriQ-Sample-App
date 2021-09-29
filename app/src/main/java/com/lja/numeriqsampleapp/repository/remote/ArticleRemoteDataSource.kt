package com.lja.numeriqsampleapp.repository.remote

import com.lja.numeriqsampleapp.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

interface ArticleRemoteDataSource {
    fun getListArticles(): Flow<List<ArticleService>>
}