package com.example.footballapp.ui.league

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class LeagueViewModel : ViewModel() {
    //val matches = MutableLiveData<State<SpecificCompetitionMatchesResponse?>>()
    val scorer = MutableLiveData<State<ScorerRankResponse?>>()
//    val scorer = FootballRepository.getCompetitionScorers(2001).asLiveData()
//    val stand = FootballRepository.getSpecificTeamRank(2021 ,"HOME" ).asLiveData()
//    val matches = FootballRepository.getSpecificCompetitionMatches(2001, null, null).asLiveData()

//    val yMatches = FootballRepository.getSpecificCompetitionMatches(
//        2001, "2021-11-03", "2021-11-03"
//    ).asLiveData()

    fun onLeagueClicked(leagueId: Int) {
        viewModelScope.launch {
            FootballRepository.getCompetitionScorers(leagueId).collect {
                scorer.postValue(it)
                Log.v("MATCHES", it.toString())
            }
        }
    }
}
//    override fun onClickScorer(scorer: Scorer) {}
//    override fun onClickMatch(match: Matche) {}
//    override fun onClickStand(standing: Standing) {}

//    override fun onClickYesterdayChip(): LiveData<State<SpecificCompetitionMatchesResponse?>> =
//        FootballRepository.getSpecificCompetitionMatches(
//            2001, "2021-11-03", "2021-11-03"
//        ).asLiveData()
//
//       viewModelScope.launch {
//           FootballRepository.getSpecificCompetitionMatches(leagueId).collect {
//               matches.postValue(it)
//               Log.v("MATCHES", it.toString())
//           }
//       }
//   }
//
//    override fun onClickTodayChip(): LiveData<State<SpecificCompetitionMatchesResponse?>> =
//        FootballRepository.getSpecificCompetitionMatches(
//            2001, "2021-11-04", "2021-11-04").asLiveData()
//
//
//
//    override fun onClickTomorrowChip(): LiveData<State<SpecificCompetitionMatchesResponse?>> =
//        FootballRepository.getSpecificCompetitionMatches(
//            2001, "2021-11-05", "2021-11-05").asLiveData()

//}