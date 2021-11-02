package com.example.footballapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.repository.FootballRepository


class HomeViewModel : ViewModel(), HomeInteractionListener {

    val liveMatches = FootballRepository.getDailyMatch().asLiveData()

    val competitions = FootballRepository.filterDataCompetitions().asLiveData()

    val topPlayer = FootballRepository.getCompetitionScorers(2021).asLiveData()

    val clickItemMatch = MutableLiveData<Int?>()

    override fun onClickSeeMore() {}

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }


}