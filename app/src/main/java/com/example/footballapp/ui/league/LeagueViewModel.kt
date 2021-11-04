package com.example.footballapp.ui.league

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.footballapp.databinding.ItemStandingBinding
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.model.domain.teamRankResponse.Standing
import com.example.footballapp.model.domain.teamRankResponse.Table
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.ui.league.matches.MatchInteractionListener
import com.example.footballapp.ui.league.scorers.ScorerInteractionListener
import com.example.footballapp.ui.league.standing.StandInteractionListener
import kotlinx.coroutines.launch


class LeagueViewModel : ViewModel(), MatchInteractionListener, ScorerInteractionListener , StandInteractionListener {

    val scorer = FootballRepository.getCompetitionScorers(2001).asLiveData()
    val matches = FootballRepository.getSpecificCompetitionMatches(2001).asLiveData()
    val stand = FootballRepository.getSpecificTeamRank(2021 ,"HOME" ).asLiveData()

    override fun onClickScorer(scorer: Scorer) {}
    override fun onClickMatch(match: Matche) {}
    override fun onClickStand(standing: Standing) {}

}