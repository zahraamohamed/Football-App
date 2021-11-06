package com.example.footballapp.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(), HomeInteractionListener {

    val liveMatches = MutableLiveData<State<MatchesResponse?>>()
    val competitions = MutableLiveData<State<CompetitionsResponse?>>()
    private val _navigateToDetails = MutableLiveData<Event<Int?>>()
    val navigateToDetails: LiveData<Event<Int?>> get() = _navigateToDetails

    val topPlayer = FootballRepository.getCompetitionScorers(2021).asLiveData()
    val clickItemMatch = MutableLiveData<Int?>()

    fun onLeagueClicked(leagueId: Int?) {
        _navigateToDetails.value = Event(leagueId)
    }

    init{
        getListAdapter()
    }

    private fun getListAdapter() {
        viewModelScope.launch {
            FootballRepository.getDailyMatch().collect { liveMatches.postValue(it) }
            FootballRepository.getAllCompetitions().collect { competitions.postValue(it) }
        }
    }

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }

}