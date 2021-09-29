package com.lja.numeriqsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import com.lja.numeriqsampleapp.usecases.GetListArticlesUseCase

class ArticlesViewModel(
    private val getListArticlesUseCase: GetListArticlesUseCase,
) : ViewModel() {


}