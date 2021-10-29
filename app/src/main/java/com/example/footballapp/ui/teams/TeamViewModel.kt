package com.example.footballapp.ui.teams


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.teamDetailsResponse.Squad
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.repository.FootballRepository

class TeamViewModel:ViewModel() , ITeamDetailsInteractionListener {


//    private val _matchDetails = MutableLiveData<State<TeamDetailsResponse?>>()
    val teamDetails=FootballRepository.getSpecificTeamDetails(18).asLiveData()



//
//    private fun getTeamDetails() {
//        val teamId = TeamDetailsResponse().id
//        if (teamId != null) {
//            val teamDetails = FootballRepository.getSpecificTeamDetails(teamId).asLiveData()
//        }
//
//    }

    override fun onClickTeamPlayer(playerDetails: Squad) {

    }
}