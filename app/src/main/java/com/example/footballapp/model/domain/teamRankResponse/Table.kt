package com.example.footballapp.model.domain.teamRankResponse


import com.google.gson.annotations.SerializedName

data class Table(
    @SerializedName("draw")
    val draw: Int? = null,
    @SerializedName("form")
    val form: Any? = null,
    @SerializedName("goalDifference")
    val goalDifference: Int? = null,
    @SerializedName("goalsAgainst")
    val goalsAgainst: Int? = null,
    @SerializedName("goalsFor")
    val goalsFor: Int? = null,
    @SerializedName("lost")
    val lost: Int? = null,
    @SerializedName("playedGames")
    val playedGames: Int? = null,
    @SerializedName("points")
    val points: Int? = null,
    @SerializedName("position")
    val position: Int? = null,
    @SerializedName("team")
    val team: Team? = null,
    @SerializedName("won")
    val won: Int? = null
)