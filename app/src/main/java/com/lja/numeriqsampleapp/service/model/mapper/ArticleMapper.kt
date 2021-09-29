package com.lja.numeriqsampleapp.service.model.mapper

import com.lja.numeriqsampleapp.service.model.service.ArticleService
import com.lja.numeriqsampleapp.service.model.shared.ArticleShared

fun ArticleService.toSharedModel() = ArticleShared(
    source = source?.name,
    author = author,
    title = title,
    description = description,
    urlToImage = urlToImage
)