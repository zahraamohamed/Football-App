package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class MatchesResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("filters")
    val filters: Filters? = null,
    @SerializedName("matches")
    val matches: List<Matche>? = null
)