package com.lja.numeriqsampleapp.model.service

data class ArticleService(
    var source: ArticleSourceService?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?,
)
