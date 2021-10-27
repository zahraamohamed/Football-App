package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("ensignUrl")
    val ensignUrl: String? = null,
    @SerializedName("name")
    val name: String? = null
)