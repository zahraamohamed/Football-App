package com.example.footballapp.model.domain.specificMatchDetailsResponse


import com.google.gson.annotations.SerializedName

data class Head2head(
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam? = null,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeam? = null,
    @SerializedName("numberOfMatches")
    val numberOfMatches: Int? = null,
    @SerializedName("totalGoals")
    val totalGoals: Int? = null
)