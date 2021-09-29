package com.lja.numeriqsampleapp.model.mapper

import com.lja.numeriqsampleapp.model.service.ArticleService
import com.lja.numeriqsampleapp.model.shared.ArticleShared

fun ArticleService.toSharedModel() = ArticleShared(
    source = source?.name,
    author = author,
    title = title,
    description = description,
    urlToImage = urlToImage
)