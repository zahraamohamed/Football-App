package com.example.footballapp.repository

import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.footballNewsResponse.FootballResponse
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.model.network.football.FootballAPI
import com.example.footballapp.model.network.news.NewsApi
import com.example.footballapp.util.Constant
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object FootballRepository {

    private fun getAllCompetitions() = wrapWithFlow { FootballAPI.apiService.getAllCompetitions() }

    @FlowPreview
    fun filterDataCompetitions(): Flow<State<List<Competition>>> =
        getAllCompetitions().flatMapConcat {
            flow {
                emit(State.Success(it.toData()?.competitions?.filter { it.plan == "TIER_TWO" }))
            }
        }

    fun getDailyMatch() = wrapWithFlow { FootballAPI.apiService.getAllMatches() }

    fun getPlayerDetails(playerId: Int?) =
        wrapWithFlow { FootballAPI.apiService.getPlayerDetails(playerId) }

    fun getCompetitionScorers(competitionId: Int?): Flow<State<ScorerRankResponse?>> =
        wrapWithFlow { FootballAPI.apiService.getCompetitionScorers(competitionId) }

    fun getSpecificMatchDetails(matchId: Int?) =
        wrapWithFlow { FootballAPI.apiService.getSpecificMatchDetails(matchId) }

    fun getSpecificCompetitionMatches(
        competitionId: Int?,
        dateFrom: String?,
        dateTo: String?,
    ): Flow<State<SpecificCompetitionMatchesResponse?>> =
        wrapWithFlow {
            FootballAPI.apiService.getSpecificCompetitionMatches(competitionId,
                dateFrom,
                dateTo)
        }

    fun getSpecificTeamDetails(teamId: Int): Flow<State<TeamDetailsResponse?>> =
        wrapWithFlow { FootballAPI.apiService.getSpecificTeamDetails(teamId) }

    fun getSpecificTeamRank(
        competitionId: Int?,
        TeamType: String = "TOTAL",
    ) = wrapWithFlow { FootballAPI.apiService.getSpecificTeamRank(competitionId, TeamType) }

    fun getFootballNews(
        country: String = "gb",
        category: String = "sports",
        apiKey: String = Constant.NEWS_API_KEY,
    ): Flow<State<FootballResponse?>> =
        wrapWithFlow {
            NewsApi.newsService.getFootballNews(country, category, apiKey)

        }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
            try {
                emit(State.Loading)
                emit(checkIsSuccessful(function()))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?> =
        if (response.isSuccessful) {
            State.Success(response.body())
        } else {
            State.Error(response.message())
        }
}