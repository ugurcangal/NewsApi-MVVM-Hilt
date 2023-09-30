package com.example.newsapiapp.data.repository.topheadlines

import com.example.newsapiapp.data.model.News
import retrofit2.Response

interface TopHeadlinesDataSource {

    suspend fun getAllTopHeadlines(): Response<News>

}