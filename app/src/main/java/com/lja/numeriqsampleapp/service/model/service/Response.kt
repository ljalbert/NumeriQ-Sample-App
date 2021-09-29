package com.lja.numeriqsampleapp.service.model.service

data class Response(
    var status: String?,
    var totalResults: Int?,
    var articles: List<ArticleService>?
)
