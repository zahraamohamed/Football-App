package com.example.footballapp.ui.league

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.ui.league.matches.MatchInteractionListener
import com.example.footballapp.ui.league.scorers.ScorerInteractionListener
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class LeagueViewModel : ViewModel(), MatchInteractionListener{
    val matches = MutableLiveData<State<SpecificCompetitionMatchesResponse?>>()
    val scorer = MutableLiveData<State<ScorerRankResponse?>>()

    override fun onClickMatch(match: Matche) {

    }

   fun onLeagueClicked(leagueId: Int) {
       viewModelScope.launch {
           FootballRepository.getCompetitionScorers(leagueId).collect {
               scorer.postValue(it)
               Log.v("MATCHES", it.toString())
           }
       }

       viewModelScope.launch {
           FootballRepository.getSpecificCompetitionMatches(leagueId).collect {
               matches.postValue(it)
               Log.v("MATCHES", it.toString())
           }
       }
   }

}