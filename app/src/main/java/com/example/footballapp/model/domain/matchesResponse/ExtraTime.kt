package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class ExtraTime(
    @SerializedName("awayTeam")
    val awayTeam: Any? = null,
    @SerializedName("homeTeam")
    val homeTeam: Any? = null
)