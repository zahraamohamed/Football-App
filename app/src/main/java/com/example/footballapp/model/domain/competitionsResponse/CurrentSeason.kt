package com.example.footballapp.model.domain.competitionsResponse


import com.google.gson.annotations.SerializedName

data class CurrentSeason(
    @SerializedName("currentMatchday")
    val currentMatchday: Int? = null,
    @SerializedName("endDate")
    val endDate: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("winner")
    val winner: Any? = null
)