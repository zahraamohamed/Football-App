package com.example.footballapp.ui.news

import androidx.lifecycle.*
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.repository.NewsFootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.Serializable

class NewsViewModel:ViewModel(),INewsListener {

    val news = NewsFootballRepository.getFootballNews().asLiveData()
    private  val _navigateToWebView = MutableLiveData <Event<Article>>()
    val navigateToWebView : LiveData <Event<Article>>  get() = _navigateToWebView

    override fun onNewsClick(articleDetails: Article) {
        _navigateToWebView.postValue(Event(articleDetails))
    }


}