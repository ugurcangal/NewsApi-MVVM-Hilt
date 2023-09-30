package com.example.newsapiapp.di

import com.example.newsapiapp.data.repository.topheadlines.TopHeadlinesDataSource
import com.example.newsapiapp.data.repository.topheadlines.TopHeadlinesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindTopHeadlinesDataSource(
        dataSource: TopHeadlinesRemoteDataSource
    ): TopHeadlinesDataSource

}