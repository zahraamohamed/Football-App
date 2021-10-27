package com.example.footballapp.model.domain.teamRankResponse


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("area")
    val area: Area? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lastUpdated")
    val lastUpdated: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("plan")
    val plan: String? = null
)