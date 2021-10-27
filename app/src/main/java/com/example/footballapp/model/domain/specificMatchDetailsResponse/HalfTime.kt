package com.example.footballapp.model.domain.specificMatchDetailsResponse


import com.google.gson.annotations.SerializedName

data class HalfTime(
    @SerializedName("awayTeam")
    val awayTeam: Int? = null,
    @SerializedName("homeTeam")
    val homeTeam: Int? = null
)