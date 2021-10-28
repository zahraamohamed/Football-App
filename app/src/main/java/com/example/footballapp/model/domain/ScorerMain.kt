package com.example.footballapp.model.domain


import com.google.gson.annotations.SerializedName

data class ScorerMain(
    @SerializedName("competition")
    var competition: Competition? = Competition(),
    @SerializedName("count")
    var count: Int? = 0,
    @SerializedName("filters")
    var filters: Filters? = Filters(),
    @SerializedName("scorers")
    var scorers: List<Scorer>? = listOf(),
    @SerializedName("season")
    var season: Season? = Season()
)