package com.example.footballapp.ui.teams


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.domain.teamDetailsResponse.Squad
import com.example.footballapp.repository.FootballRepository

class TeamViewModel : ViewModel(), ITeamDetailsInteractionListener {

    val teamDetails = FootballRepository.getSpecificTeamDetails(18).asLiveData()

    override fun onClickTeamPlayer(playerDetails: Squad) {}
}