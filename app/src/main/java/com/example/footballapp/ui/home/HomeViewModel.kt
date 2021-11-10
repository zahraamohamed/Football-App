package com.example.footballapp.ui.home

import androidx.lifecycle.*
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event


class HomeViewModel : ViewModel(), HomeInteractionListener {

    val matches = FootballRepository.getDailyMatch().asLiveData()
    val competitions = FootballRepository.filterDataCompetitions().asLiveData()
    val news = FootballRepository.getFootballNews().asLiveData()


    private val _navigateToLeagueDetails = MutableLiveData<Event<Pair<Int, String>>>()
    val navigateToLeagueDetails: LiveData<Event<Pair<Int, String>>> get() = _navigateToLeagueDetails
    private val clickItemMatch = MutableLiveData<Int?>()





    override fun onLeagueClicked(leagueId: Int?, leagueName: String? ) {
        _navigateToLeagueDetails.value = Event(Pair(leagueId ?: 0, leagueName ?: ""))
    }

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }

    private val _navigateToWebView = MutableLiveData<Event<Article>>()
    val navigateToWebView: LiveData<Event<Article>> get() = _navigateToWebView

    override fun onNewsClick(articleDetails: Article) {
        _navigateToWebView.postValue(Event(articleDetails))
    }

}