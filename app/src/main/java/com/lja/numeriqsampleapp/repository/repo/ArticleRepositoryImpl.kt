package com.lja.numeriqsampleapp.repository.repo

import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSource
import com.lja.numeriqsampleapp.service.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

class ArticleRepositoryImpl(
    // TODO IMPLEMENT A LOCAL DATASOURCE
    //private val localDataSource: DataModelLocalDataSourceImpl,
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {

    override suspend fun getListArticles(
        keyWords: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): Flow<List<ArticleService>> {
        return remoteDataSource.getListArticles(keyWords, from, sortBy, apiKey)
    }
}