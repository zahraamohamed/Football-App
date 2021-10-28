package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class FullTime(
    @SerializedName("awayTeam")
    val awayTeam: Int? = null,
    @SerializedName("homeTeam")
    val homeTeam: Int? = null
)