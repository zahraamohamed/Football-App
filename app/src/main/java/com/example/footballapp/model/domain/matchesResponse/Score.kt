package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("duration")
    val duration: String? = null,
    @SerializedName("extraTime")
    val extraTime: ExtraTime? = null,
    @SerializedName("fullTime")
    val fullTime: FullTime? = null,
    @SerializedName("halfTime")
    val halfTime: HalfTime? = null,
    @SerializedName("penalties")
    val penalties: Penalties? = null,
    @SerializedName("winner")
    val winner: Any? = null
)