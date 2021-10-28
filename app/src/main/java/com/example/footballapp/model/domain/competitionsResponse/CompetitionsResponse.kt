package com.example.footballapp.model.domain.competitionsResponse


import com.google.gson.annotations.SerializedName

data class CompetitionsResponse(
    @SerializedName("competitions")
    val competitions: List<Competition>? = null,
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("filters")
    val filters: Filters? = null
)