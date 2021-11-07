package com.example.footballapp.ui.news

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.model.network.NewsApi
import com.example.footballapp.repository.NewsFootballRepository
import kotlinx.coroutines.launch

class NewsViewModel:ViewModel(),INewsListener {

    val news = NewsFootballRepository.getFootballNews().asLiveData()
    override fun onNewsClick(articleDetails: Article) {
        TODO("Not yet implemented")
    }
}