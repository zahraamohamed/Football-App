package com.example.footballapp.model.domain.scorerRankResponse


import com.google.gson.annotations.SerializedName

data class ScorerRankResponse(
    @SerializedName("competition")
    val competition: Competition? = null,
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("filters")
    val filters: Filters? = null,
    @SerializedName("scorers")
    val scorers: List<Scorer>? = null,
    @SerializedName("season")
    val season: Season? = null
)