package com.example.footballapp.model.domain.specificMatchDetailsResponse


import com.google.gson.annotations.SerializedName

data class AwayTeam(
    @SerializedName("draws")
    val draws: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("losses")
    val losses: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("wins")
    val wins: Int? = null
)