package com.lja.numeriqsampleapp.repository.remote

import com.lja.numeriqsampleapp.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

class ArticleRemoteDataSourceImpl : ArticleRemoteDataSource {
    override fun getListArticles(): Flow<List<ArticleService>> {
        TODO("Not yet implemented")
    }
}