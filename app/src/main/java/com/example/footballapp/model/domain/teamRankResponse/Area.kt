package com.example.footballapp.model.domain.teamRankResponse


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)