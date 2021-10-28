package com.example.footballapp.model.network

import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.model.domain.playerDetailsResponse.playerDetailsResponse
import com.example.footballapp.model.domain.scorerRankResponse.ScorerRankResponse
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.model.domain.teamRankResponse.TeamRankResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballApiService {

    @GET("competitions")
    suspend fun getAllCompetitions(): Response<CompetitionsResponse>

    @GET("matches/")
    suspend fun getAllMatches(): Response<MatchesResponse>

    @GET("players/{id}")
    suspend fun getPlayerDetails(
        @Header("X-Auth-Token") token: String,
        @Path("id") playerId: Int
    ): Response<playerDetailsResponse>

    @GET("matches/{id}")
    suspend fun getScorerRank(
        @Header("X-Auth-Token") token: String,
        @Path("id") scorerId: Int
    ): Response<ScorerRankResponse>

    @GET("competitions/{id}/matches")
    suspend fun getSpecificCompetitionMatches(
        @Header("X-Auth-Token") token: String,
        @Path("id") competitionId: Int
    ): Response<SpecificCompetitionMatchesResponse>

    @GET("teams/{id}")
    suspend fun getSpecificTeamDetails(
        @Header("X-Auth-Token") token: String,
        @Path("id") teamId: Int
    ): Response<TeamDetailsResponse>

    @GET("competitions/{id}/standings")
    suspend fun getSpecificTeamRank(
        @Header("X-Auth-Token") token: String,
        @Path("id") competitionId: Int,
        @Query("standingType") TeamType: String
    ): Response<TeamRankResponse>

}