package com.lja.numeriqsampleapp.repository.repo

import com.lja.numeriqsampleapp.model.service.ArticleService
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSource
import kotlinx.coroutines.flow.Flow

class ArticleRepositoryImpl(
    // TODO IMPLEMENT A LOCAL DATASOURCE
    //private val localDataSource: DataModelLocalDataSourceImpl,
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {

    override fun getListArticles(): Flow<List<ArticleService>> {
        return remoteDataSource.getListArticles()
    }
}