package com.lja.numeriqsampleapp.di

import com.lja.numeriqsampleapp.BuildConfig
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSource
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSourceImpl
import com.lja.numeriqsampleapp.repository.repo.ArticleRepository
import com.lja.numeriqsampleapp.repository.repo.ArticleRepositoryImpl
import com.lja.numeriqsampleapp.usecases.GetListArticlesUseCase
import com.lja.numeriqsampleapp.viewmodel.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Koin modules
 */
val appModule = module {
    factory<ArticleRemoteDataSource> {
        ArticleRemoteDataSourceImpl(
            articlesApi = get()
        )
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

val serviceModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(Response::class.java)
    }
}