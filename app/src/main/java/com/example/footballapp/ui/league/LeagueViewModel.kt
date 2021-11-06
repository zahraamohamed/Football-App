package com.example.footballapp.ui.league

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.ui.league.matches.MatchInteractionListener
import com.example.footballapp.ui.league.scorers.ScorerInteractionListener

class LeagueViewModel : ViewModel(), MatchInteractionListener, ScorerInteractionListener {

    val scorer = FootballRepository.getCompetitionScorers(2001).asLiveData()
    val matches = FootballRepository.getSpecificCompetitionMatches(2001, null, null).asLiveData()

    val yMatches = FootballRepository.getSpecificCompetitionMatches(
        2001, "2021-11-03", "2021-11-03"
    ).asLiveData()

    val value = MutableLiveData<String>()
    

    override fun onClickScorer(scorer: Scorer) {

    }

    override fun onClickMatch(match: Matche) {

    }

    override fun onClickYesterdayChip(): LiveData<State<SpecificCompetitionMatchesResponse?>> =
        FootballRepository.getSpecificCompetitionMatches(
            2001, "2021-11-03", "2021-11-03"
        ).asLiveData()


    override fun onClickTodayChip(): LiveData<State<SpecificCompetitionMatchesResponse?>> =
        FootballRepository.getSpecificCompetitionMatches(
            2001, "2021-11-04", "2021-11-04").asLiveData()



    override fun onClickTomorrowChip(): LiveData<State<SpecificCompetitionMatchesResponse?>> =
        FootballRepository.getSpecificCompetitionMatches(
            2001, "2021-11-05", "2021-11-05").asLiveData()

}