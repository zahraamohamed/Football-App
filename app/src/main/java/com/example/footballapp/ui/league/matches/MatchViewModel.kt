package com.example.footballapp.ui.league.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MatchViewModel:ViewModel(), MatchInteractionListener {
    val matches = MutableLiveData<State<SpecificCompetitionMatchesResponse?>>()
    private val _navigateToMatchDetails = MutableLiveData<Event<Int?>>()
    val navigateToMatchDetails: LiveData<Event<Int?>> get() = _navigateToMatchDetails

    override fun onClickMatch(id: Int?) = _navigateToMatchDetails.postValue(Event(id))

    override fun onMatchLoad(id: Int?) {
        id?.let {
            viewModelScope.launch {
                FootballRepository.getSpecificCompetitionMatches(2003, null, null).collect {
                    matches.postValue(it)
                }
            }
        }
    }
}
