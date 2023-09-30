package com.example.newsapiapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapiapp.data.model.News
import com.example.newsapiapp.data.repository.topheadlines.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val topHeadlinesRepository: TopHeadlinesRepository) : ViewModel() {

    val allTopHeadlines = MutableLiveData<News>()

    init {
        getAllTopHeadlines()
    }


    fun getAllTopHeadlines() = viewModelScope.launch {
        val response = topHeadlinesRepository.getAllTopHeadlines()
        if (response.isSuccessful){
            allTopHeadlines.postValue(response.body())
        }
    }


}