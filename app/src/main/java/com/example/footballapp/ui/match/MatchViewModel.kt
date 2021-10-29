package com.example.footballapp.ui.match


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.repository.FootballRepository

class MatchViewModel:ViewModel() {

    val matchDetails=FootballRepository.getSpecificCompetitionMatches(18).asLiveData()

//    private val _matchDetails = MutableLiveData<State<SpecificMatchDetailsResponse?>>()
//    val matchDetails :LiveData<State<SpecificMatchDetailsResponse?>>
//        get() = _matchDetails
//    init {
//        getMatchDetails()
//    }
//
//    private fun getMatchDetails() {
//        val teamId:Int? = Match().id
//        if (teamId != null) {
//            FootballRepository.getSpecificCompetitionMatches(teamId).asLiveData()
//        }
//
//    }
}