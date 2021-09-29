package com.lja.numeriqsampleapp.usecases

import com.lja.numeriqsampleapp.model.service.ArticleService
import com.lja.numeriqsampleapp.repository.repo.ArticleRepository
import kotlinx.coroutines.flow.Flow

class GetListArticlesUseCase(private val articleRepository: ArticleRepository) {

    fun execute(): Flow<List<ArticleService>> {
        return articleRepository.getListArticles()
    }
}