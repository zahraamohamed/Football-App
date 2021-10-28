package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class Matche(
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam? = null,
    @SerializedName("competition")
    val competition: Competition? = null,
    @SerializedName("group")
    val group: Any? = null,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeam? = null,
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
    val utcDate: String? = null
)