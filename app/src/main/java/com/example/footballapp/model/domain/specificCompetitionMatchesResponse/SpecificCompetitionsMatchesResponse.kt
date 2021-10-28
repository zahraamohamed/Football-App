package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class SpecificCompetitionsMatchesResponse(
    @SerializedName("head2head")
    val head2head: Head2head? = null,
    @SerializedName("match")
    val match: Match? = null
)