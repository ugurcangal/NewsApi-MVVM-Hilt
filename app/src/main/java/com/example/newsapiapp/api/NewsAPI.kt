package com.example.newsapiapp.api

import com.example.newsapiapp.data.model.News
import com.example.newsapiapp.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getAllTopHeadlines(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : Response<News>

}