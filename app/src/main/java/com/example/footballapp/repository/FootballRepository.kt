package com.example.footballapp.repository

import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.model.domain.teamRankResponse.TeamRankResponse
import com.example.footballapp.model.network.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object FootballRepository {

    fun getAllCompetitions(): Flow<State<CompetitionsResponse?>> =
        wrapWithFlow { API.apiService.getAllCompetitions() }

    fun getDailyMatch(): Flow<State<MatchesResponse?>> =
        wrapWithFlow { API.apiService.getAllMatches() }

    fun getPlayerDetails(playerId: Int): Flow<State<PlayerDetailsResponse?>> {
        return wrapWithFlow { API.apiService.getPlayerDetails(playerId) }
    }

    fun getScorerRank(scorerId: Int): Flow<State<ScorerRankResponse?>> =
        wrapWithFlow { API.apiService.getScorerRank(scorerId) }

    fun getCompetitionScorers(competitionId: Int?): Flow<State<ScorerRankResponse?>> =
        wrapWithFlow { API.apiService.getCompetitionScorers(competitionId) }

    fun getSpecificMatchDetails(matchId: Int?): Flow<State<SpecificMatchDetailsResponse?>> =
        wrapWithFlow { API.apiService.getSpecificMatchDetails(matchId) }

    fun getSpecificCompetitionMatches(competitionId: Int?): Flow<State<SpecificCompetitionMatchesResponse?>> =
        wrapWithFlow { API.apiService.getSpecificCompetitionMatches(competitionId) }

    fun getSpecificTeamDetails(teamId: Int): Flow<State<TeamDetailsResponse?>> =
        wrapWithFlow { API.apiService.getSpecificTeamDetails(teamId) }

    fun getSpecificTeamRank(
        competitionId: Int,
        TeamType: String = "TOTAL"
    ): Flow<State<TeamRankResponse?>> =
        wrapWithFlow { API.apiService.getSpecificTeamRank(competitionId, TeamType) }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
            emit(State.Loading)
            emit(checkIsSuccessful(function()))
        }

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?> =
        try {
            if (response.isSuccessful) {
                State.Success(response.body())
            } else {
                State.Error(response.message())
            }
        } catch (e: Exception) {
            State.Error(e.message.toString())
        }

}