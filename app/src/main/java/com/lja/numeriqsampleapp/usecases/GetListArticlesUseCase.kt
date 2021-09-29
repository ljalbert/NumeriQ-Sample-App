package com.lja.numeriqsampleapp.usecases

import com.lja.numeriqsampleapp.repository.repo.ArticleRepository
import com.lja.numeriqsampleapp.service.model.service.ArticleService
import kotlinx.coroutines.flow.Flow

class GetListArticlesUseCase(private val articleRepository: ArticleRepository) {

    suspend fun execute(
        keyWords: String,
        from: String,
        sortBy: String,
        apiKey: String
    ): Flow<List<ArticleService>> {
        return articleRepository.getListArticles(keyWords, from, sortBy, apiKey)
    }
}