package com.example.footballapp.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.teamDetailsResponse.Squad
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.repository.FootballRepository

class TeameViewModel:ViewModel() , ITeamDetailsInteractionListener {

    private val repository = FootballRepository
    private val _matchDetails = MutableLiveData<State<TeamDetailsResponse?>>()
    val matchDetails: LiveData<State<TeamDetailsResponse?>>
        get() = _matchDetails

    init {
        getTeamDetails()
    }

    private fun getTeamDetails() {
        val teamId = TeamDetailsResponse().id
        if (teamId != null) {
            val teamDetails = repository.getSpecificTeamDetails(teamId).asLiveData()
        }

    }

    override fun onClickTeamPlayer(playerDetails: Squad) {

    }
}