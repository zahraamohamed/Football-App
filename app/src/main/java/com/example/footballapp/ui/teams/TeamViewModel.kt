package com.example.footballapp.ui.teams


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.teamDetailsResponse.Squad
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel(), ITeamDetailsInteractionListener {
    private val _teamDetails = MutableLiveData<State<TeamDetailsResponse?>>()
    val teamDetails: LiveData<State<TeamDetailsResponse?>> get() = _teamDetails

    private val _navigateToPlayerDetails = MutableLiveData<Event<Int?>>()
    val navigateToPlayerDetails: LiveData<Event<Int?>> get() = _navigateToPlayerDetails

    override fun onLoadTeam(id: Int) {
        viewModelScope.launch {
            FootballRepository.getSpecificTeamDetails(id).collect { _teamDetails.postValue(it) }
        }
    }

    override fun onClickTeamPlayer(playerDetails: Squad) {}
}