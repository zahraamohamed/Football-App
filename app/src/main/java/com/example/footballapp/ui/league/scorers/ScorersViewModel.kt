package com.example.footballapp.ui.league.scorers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event

class ScorersViewModel : ViewModel(), ScorerInteractionListener {
    val scorer = FootballRepository.getCompetitionScorers(2001).asLiveData()
    private val _navigateToPlayerDetails = MutableLiveData<Event<Int>>()
    val navigateToPlayerDetails: LiveData<Event<Int>> get() = _navigateToPlayerDetails

//    val scorer = MutableLiveData<State<ScorerRankResponse?>>()


    override fun onClickScorer(id: Int) {
        _navigateToPlayerDetails.postValue(Event(id))
    }

}