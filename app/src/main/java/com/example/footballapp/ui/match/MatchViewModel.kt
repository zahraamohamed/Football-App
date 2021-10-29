package com.example.footballapp.ui.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.specificMatchDetailsResponse.Match
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.repository.FootballRepository

class MatchViewModel:ViewModel() {

    private val _matchDetails = MutableLiveData<State<SpecificMatchDetailsResponse?>>()
    val matchDetails :LiveData<State<SpecificMatchDetailsResponse?>>
        get() = _matchDetails
    init {
        getMatchDetails()
    }

    private fun getMatchDetails() {
        val teamId:Int? = Match().id
        if (teamId != null) {
            FootballRepository.getSpecificCompetitionMatches(teamId).asLiveData()
        }

    }
}