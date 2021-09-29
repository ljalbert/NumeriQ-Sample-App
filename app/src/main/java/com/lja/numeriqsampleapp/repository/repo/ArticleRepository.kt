package com.lja.numeriqsampleapp.repository.repo

import com.lja.numeriqsampleapp.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getListArticles(): Flow<List<ArticleService>>
}