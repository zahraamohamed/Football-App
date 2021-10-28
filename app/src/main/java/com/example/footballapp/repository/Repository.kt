package com.example.footballapp.repository

import com.example.footballapp.model.Status
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.model.domain.teamRankResponse.TeamRankResponse
import com.example.footballapp.model.network.API
import com.example.footballapp.util.Constant.API_TOKEN
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

object Repository {

    fun getAllCompetitions(): Flow<Status<CompetitionsResponse?>> =
        wrapWithFlow { API.apiService.getAllCompetitions() }

    fun getAllMatch(): Flow<Status<MatchesResponse?>> =
        wrapWithFlow { API.apiService.getAllMatches() }

    fun getPlayerDetails(playerId: Int): Flow<Status<PlayerDetailsResponse?>> =
        wrapWithFlow { API.apiService.getPlayerDetails(API_TOKEN, playerId) }

    fun getScorerRank(scorerId: Int): Flow<Status<ScorerRankResponse?>> =
        wrapWithFlow { API.apiService.getScorerRank(API_TOKEN, scorerId) }

    fun getSpecificCompetitionMatches(competitionId: Int): Flow<Status<SpecificCompetitionMatchesResponse?>> =
        wrapWithFlow { API.apiService.getSpecificCompetitionMatches(API_TOKEN, competitionId) }

    fun getSpecificTeamDetails(teamId: Int): Flow<Status<TeamDetailsResponse?>> =
        wrapWithFlow { API.apiService.getSpecificTeamDetails(API_TOKEN, teamId) }

    fun getSpecificTeamRank(competitionId: Int , TeamType: String = "TOTAL"): Flow<Status<TeamRankResponse?>> =
        wrapWithFlow { API.apiService.getSpecificTeamRank(API_TOKEN, competitionId , TeamType) }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<Status<T?>> =
        flow {
            emit(Status.Loading)
            emit(checkIsSuccessful(function()))
        }

    private fun <T> checkIsSuccessful(response: Response<T>): Status<T?> =
        try {
            if (response.isSuccessful) {
                Status.Success(response.body())
            } else {
                Status.Error(response.message())
            }
        } catch (e: Exception) {
            Status.Error(e.message.toString())
        }

}