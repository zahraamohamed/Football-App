package com.example.footballapp.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.repository.NewsFootballRepository

class NewsViewModel:ViewModel(),INewsListener {

    val news = NewsFootballRepository.getFootballNews().asLiveData()
    override fun onNewsClick(articleDetails: Article) {
        TODO("Not yet implemented")
    }
}