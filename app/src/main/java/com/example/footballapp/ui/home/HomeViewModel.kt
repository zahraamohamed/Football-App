package com.example.footballapp.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.repository.NewsFootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(), HomeInteractionListener {

    val liveMatches = FootballRepository.getDailyMatch().asLiveData()
    private val _navigateToDetails = MutableLiveData<Event<Pair<Int, String>>>()
    val navigateToDetails: LiveData<Event<Pair<Int, String>>> get() = _navigateToDetails
    val competitions = FootballRepository.filterDataCompetitions().asLiveData()
    val news = NewsFootballRepository.getFootballNews().asLiveData()
    val clickItemMatch = MutableLiveData<Int?>()

    fun onLeagueClicked(leagueId: Int?, leagueName: String? = null) {
        _navigateToDetails.value = Event(Pair(leagueId ?: 0, leagueName ?: ""))
    }

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }

    private  val _navigateToWebView = MutableLiveData <Event<Article>>()
    val navigateToWebView : LiveData <Event<Article>>  get() = _navigateToWebView

    override fun onNewsClick(articleDetails: Article) {
        _navigateToWebView.postValue(Event(articleDetails))
    }

}