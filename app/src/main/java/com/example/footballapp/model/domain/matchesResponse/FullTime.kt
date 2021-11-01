package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class  FullTime(
    @SerializedName("awayTeam")
    val awayTeam: Int? = null,
    @SerializedName("homeTeam")
    val homeTeam: Int? = null
)