package com.example.footballapp.ui.league.scorers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScorersViewModel : ViewModel(), ScorerInteractionListener {
    val scorer = MutableLiveData<State<ScorerRankResponse?>>()
    private val _navigateToPlayerDetails = MutableLiveData<Event<Int>>()
    val navigateToPlayerDetails: LiveData<Event<Int>> get() = _navigateToPlayerDetails

    override fun onScorerLoad(id: Int?) {
        viewModelScope.launch {
            FootballRepository.getCompetitionScorers(2003).collect {
                scorer.postValue(it)
            }
        }
    }

    override fun onClickScorer(id: Int) = _navigateToPlayerDetails.postValue(Event(id))
}