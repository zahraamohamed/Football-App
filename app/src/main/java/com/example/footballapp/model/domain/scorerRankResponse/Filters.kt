package com.example.footballapp.model.domain.scorerRankResponse


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("limit")
    val limit: Int? = null
)