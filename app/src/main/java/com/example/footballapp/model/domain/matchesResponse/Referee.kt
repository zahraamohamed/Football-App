package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class Referee(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nationality")
    val nationality: String? = null,
    @SerializedName("role")
    val role: String? = null
)