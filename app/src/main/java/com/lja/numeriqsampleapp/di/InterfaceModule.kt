package com.lja.numeriqsampleapp.di

import com.lja.numeriqsampleapp.repository.local.ArticleLocalDataSource
import com.lja.numeriqsampleapp.repository.local.ArticleLocalDataSourceImpl
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSource
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSourceImpl
import com.lja.numeriqsampleapp.repository.repo.ArticleRepository
import com.lja.numeriqsampleapp.repository.repo.ArticleRepositoryImpl
import com.lja.numeriqsampleapp.usecases.GetListArticlesUseCase
import com.lja.numeriqsampleapp.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 * Koin modules
 */
val appModule = module {

    factory<ArticleLocalDataSource> {
        ArticleLocalDataSourceImpl()
    }

    factory<ArticleRemoteDataSource> {
        ArticleRemoteDataSourceImpl()
    }

    factory<ArticleRepository> {
        ArticleRepositoryImpl(
            //localDataSource = get(),
            remoteDataSource = get()
        )
    }

    single {
        GetListArticlesUseCase(
            articleRepository = get()
        )
    }
}

val viewModelModule = module {
    viewModel {
        ArticlesViewModel(
            getListArticlesUseCase = get(),
        )
    }
}