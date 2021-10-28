package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class SpecificCompetitionMatchesResponse(
    @SerializedName("competition")
    val competition: Competition? = null,
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("filters")
    val filters: Filters? = null,
    @SerializedName("matches")
    val matches: List<Matche>? = null
)