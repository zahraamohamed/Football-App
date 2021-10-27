package com.example.footballapp.model.domain.scorerRankResponse


import com.google.gson.annotations.SerializedName

data class Scorer(
    @SerializedName("numberOfGoals")
    val numberOfGoals: Int? = null,
    @SerializedName("player")
    val player: Player? = null,
    @SerializedName("team")
    val team: Team? = null
)