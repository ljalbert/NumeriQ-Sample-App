package com.lja.numeriqsampleapp.repository.remote

import com.lja.numeriqsampleapp.service.api.ArticlesApi
import com.lja.numeriqsampleapp.service.model.service.ArticleService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleRemoteDataSourceImpl(
    private val articlesApi: ArticlesApi
) : ArticleRemoteDataSource {

    override suspend fun getListArticles(
        keyWords: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): Flow<List<ArticleService>> {
        return flow {
                val articles = articlesApi.getNewReleases(
                    keyWords = keyWords,
                    from = from,
                    sortBy = sortBy,
                    apiKey = apiKey
                ).articles!!

            emit(articles)
        }
    }
}