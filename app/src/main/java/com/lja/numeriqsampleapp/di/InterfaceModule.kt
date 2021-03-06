package com.lja.numeriqsampleapp.di

import com.lja.numeriqsampleapp.BuildConfig
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSource
import com.lja.numeriqsampleapp.repository.remote.ArticleRemoteDataSourceImpl
import com.lja.numeriqsampleapp.repository.repo.ArticleRepository
import com.lja.numeriqsampleapp.repository.repo.ArticleRepositoryImpl
import com.lja.numeriqsampleapp.service.api.ArticlesApi
import com.lja.numeriqsampleapp.usecases.GetListArticlesUseCase
import com.lja.numeriqsampleapp.viewmodel.ArticlesViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Koin modules
 */
val serviceModule = module {

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val client : OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
    }.build()

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .build()
            .create(ArticlesApi::class.java)
    }
}

val repoModule = module {

    factory<ArticleRemoteDataSource> {
        ArticleRemoteDataSourceImpl(get())
    }

    factory<ArticleRepository> {
        ArticleRepositoryImpl(
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
            getListArticlesUseCase = get()
        )
    }
}