package com.lja.numeriqsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lja.numeriqsampleapp.BuildConfig
import com.lja.numeriqsampleapp.service.model.mapper.toSharedModel
import com.lja.numeriqsampleapp.service.model.shared.ArticleShared
import com.lja.numeriqsampleapp.usecases.GetListArticlesUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val getListArticlesUseCase: GetListArticlesUseCase,
) : ViewModel() {

    private val _listArticlesFlow = MutableStateFlow<State<List<ArticleShared>>>(State.Loading)
    val listArticlesFlow: StateFlow<State<List<ArticleShared>>> = _listArticlesFlow

    init {
        viewModelScope.launch {
            getListArticlesUseCase.execute(
                keyWords = BuildConfig.QUERY,
                from = BuildConfig.FROM,
                sortBy = BuildConfig.SORTBY,
                apiKey = BuildConfig.API_KEY
            )
                .onStart { _listArticlesFlow.value = State.Loading }
                .catch {
                    _listArticlesFlow.value = State.Error(Throwable(it.localizedMessage))
                }.collect { articles ->
                    _listArticlesFlow.value = State.Success(articles.map { it.toSharedModel() })
                }
        }
    }
}