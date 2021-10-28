package com.example.footballapp.model.domain.teamDetailsResponse


import com.google.gson.annotations.SerializedName

data class ActiveCompetition(
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