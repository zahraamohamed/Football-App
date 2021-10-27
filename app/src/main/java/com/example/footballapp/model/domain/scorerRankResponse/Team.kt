package com.example.footballapp.model.domain.scorerRankResponse


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)