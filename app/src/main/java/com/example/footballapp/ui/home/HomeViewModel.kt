package com.example.footballapp.ui.home

import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.State.*
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.repository.NewsFootballRepository
import com.example.footballapp.util.Event


class HomeViewModel : ViewModel(), HomeInteractionListener {

    val matches = FootballRepository.getDailyMatch().asLiveData()
    val competitions = FootballRepository.filterDataCompetitions().asLiveData()
    val news = NewsFootballRepository.getFootballNews().asLiveData()


    private val _navigateToLeagueDetails = MutableLiveData<Event<Pair<Int, String>>>()
    val navigateToLeagueDetails: LiveData<Event<Pair<Int, String>>> get() = _navigateToLeagueDetails
    private val clickItemMatch = MutableLiveData<Int?>()





    fun onLeagueClicked(leagueId: Int?, leagueName: String? = null) {
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


    var statusHome = MediatorLiveData<State<Any?>>().apply {
        addSource(competitions) { postValue(checkStatus(it)) }
        addSource(matches) { postValue(checkStatus(it)) }
        addSource(news) { postValue(checkStatus(it)) }
    }


    private fun <T> checkStatus(state: State<T>): State<T>? =
        when {
            state is Success -> Success(state.toData())

            (matches.value is Loading &&
                    news.value is Loading) -> Loading

            (matches.value is Error &&
                    news.value is Error) -> Error("Error!")

            else -> null
        }

}