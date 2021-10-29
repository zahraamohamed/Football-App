package com.example.footballapp.ui.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.ui.league.matches.MatchInteractionListener
import com.example.footballapp.ui.league.scorers.ScorerInteractionListener
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.ui.base.BaseInteractionListener

class LeagueViewModel : ViewModel(), ScorerInteractionListener, MatchInteractionListener {

    val scorer = FootballRepository.getCompetitionScorers(2001).asLiveData()
    val matches = FootballRepository.getSpecificCompetitionMatches(2001).asLiveData()

    override fun onClickScorer(scorer: Scorer) {
    }

    override fun onClickMatch(math: Matche) {

    }

}