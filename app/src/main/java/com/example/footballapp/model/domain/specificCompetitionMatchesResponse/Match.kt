package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("awayTeam")
    val awayTeam: AwayTeamX? = null,
    @SerializedName("competition")
    val competition: Competition? = null,
    @SerializedName("group")
    val group: String? = null,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeamX? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lastUpdated")
    val lastUpdated: String? = null,
    @SerializedName("matchday")
    val matchday: Int? = null,
    @SerializedName("odds")
    val odds: Odds? = null,
    @SerializedName("referees")
    val referees: List<Referee>? = null,
    @SerializedName("score")
    val score: Score? = null,
    @SerializedName("season")
    val season: Season? = null,
    @SerializedName("stage")
    val stage: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("utcDate")
    val utcDate: String? = null,
    @SerializedName("venue")
    val venue: String? = null
)