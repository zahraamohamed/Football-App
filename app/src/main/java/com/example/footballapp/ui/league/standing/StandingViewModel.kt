package com.example.footballapp.ui.league.standing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.teamRankResponse.TeamRankResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StandingViewModel : ViewModel(), StandingInteractionListener {
    val standing = MutableLiveData<State<TeamRankResponse?>>()
    private val _navigateToTeamDetails = MutableLiveData<Event<Int>>()
    val navigateToTeamDetails: LiveData<Event<Int>> get() = _navigateToTeamDetails

    override fun onScorerLoad(id: Int?) {
        viewModelScope.launch {
            FootballRepository.getSpecificTeamRank(2003).collect {
                standing.postValue(it)
            }
        }
    }
    
    override fun onClickStand(id: Int) = _navigateToTeamDetails.postValue(Event(id))
}