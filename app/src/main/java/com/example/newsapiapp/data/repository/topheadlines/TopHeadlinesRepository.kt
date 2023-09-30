package com.example.newsapiapp.data.repository.topheadlines

import com.example.newsapiapp.data.model.News
import retrofit2.Response
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(private val topHeadlinesDataSource: TopHeadlinesDataSource) {

    suspend fun getAllTopHeadlines(): Response<News>{
        return topHeadlinesDataSource.getAllTopHeadlines()
    }

}