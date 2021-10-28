package com.example.footballapp.model.domain.teamRankResponse


import com.google.gson.annotations.SerializedName

data class TeamRankResponse(
    @SerializedName("competition")
    val competition: Competition? = null,
    @SerializedName("filters")
    val filters: Filters? = null,
    @SerializedName("season")
    val season: Season? = null,
    @SerializedName("standings")
    val standings: List<Standing>? = null
)