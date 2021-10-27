package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("currentMatchday")
    val currentMatchday: Int? = null,
    @SerializedName("endDate")
    val endDate: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("startDate")
    val startDate: String? = null
)