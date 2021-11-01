package com.example.footballapp.model.domain.competitionsResponse


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("area")
    val area: Area? = null,
    @SerializedName("code")
    val code: Any? = null,
    @SerializedName("currentSeason")
    val currentSeason: CurrentSeason? = null,
    @SerializedName("emblemUrl")
    val emblemUrl: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lastUpdated")
    val lastUpdated: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("numberOfAvailableSeasons")
    val numberOfAvailableSeasons: Int? = null,
    @SerializedName("plan")
    val plan: String? = null
)