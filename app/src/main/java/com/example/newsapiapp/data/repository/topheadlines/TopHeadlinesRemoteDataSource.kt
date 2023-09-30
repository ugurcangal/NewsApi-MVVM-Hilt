package com.example.newsapiapp.data.repository.topheadlines

import com.example.newsapiapp.api.NewsAPI
import com.example.newsapiapp.data.model.News
import retrofit2.Response
import javax.inject.Inject

class TopHeadlinesRemoteDataSource @Inject constructor(private val api: NewsAPI) : TopHeadlinesDataSource {

    override suspend fun getAllTopHeadlines(): Response<News> {
        val response = api.getAllTopHeadlines()
        return response
    }
}