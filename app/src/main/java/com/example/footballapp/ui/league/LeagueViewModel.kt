package com.example.footballapp.ui.league

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.footballapp.databinding.ItemStandingBinding
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.model.domain.teamRankResponse.Standing
import com.example.footballapp.model.domain.teamRankResponse.Table
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.ui.league.matches.MatchInteractionListener
import com.example.footballapp.ui.league.scorers.ScorerInteractionListener
import com.example.footballapp.ui.league.standing.StandInteractionListener
import kotlinx.coroutines.launch


class LeagueViewModel : ViewModel(), MatchInteractionListener, ScorerInteractionListener , StandInteractionListener {

    val scorer = FootballRepository.getCompetitionScorers(2001).asLiveData()
    val stand = FootballRepository.getSpecificTeamRank(2021 ,"HOME" ).asLiveData()
    val matches = FootballRepository.getSpecificCompetitionMatches(2001, null, null).asLiveData()

    val yMatches = FootballRepository.getSpecificCompetitionMatches(
        2001, "2021-11-03", "2021-11-03"
    ).asLiveData()


    override fun onClickScorer(scorer: Scorer) {}
    override fun onClickMatch(match: Matche) {}
    override fun onClickStand(standing: Standing) {}

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