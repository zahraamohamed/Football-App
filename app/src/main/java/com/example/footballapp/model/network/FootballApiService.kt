package com.example.footballapp.model.network

import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.model.domain.teamRankResponse.TeamRankResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballApiService {

    @GET("competitions")
    suspend fun getAllCompetitions(): Response<CompetitionsResponse>

    @GET("matches/")
    suspend fun getAllMatches(): Response<MatchesResponse>

    @GET("players/{id}")
    suspend fun getPlayerDetails(
        @Path("id") playerId: Int
    ): Response<PlayerDetailsResponse>

    @GET("matches/{id}")
    suspend fun getScorerRank(
        @Path("id") scorerId: Int
    ): Response<ScorerRankResponse>

    @GET("competitions/{id}/matches")
    suspend fun getSpecificCompetitionMatches(
        @Path("id") competitionId: Int?
    ): Response<SpecificCompetitionMatchesResponse>

    @GET("matches/{id}")
    suspend fun getSpecificMatchDetails(
        @Path("id") matchId: Int?
    ): Response<SpecificMatchDetailsResponse>

    @GET("teams/{id}")
    suspend fun getSpecificTeamDetails(
        @Path("id") teamId: Int
    ): Response<TeamDetailsResponse>

    @GET("competitions/{id}/standings")
    suspend fun getSpecificTeamRank(
        @Path("id") competitionId: Int,
        @Query("standingType") TeamType: String
    ): Response<TeamRankResponse>

    @GET("competitions/{competitionId}/scorers")
    suspend fun getCompetitionScorers(
        @Path("competitionId") competitionId: Int?
    ): Response<ScorerRankResponse>

}