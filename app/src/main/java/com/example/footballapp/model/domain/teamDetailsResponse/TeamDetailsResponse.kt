package com.example.footballapp.model.domain.teamDetailsResponse


import com.google.gson.annotations.SerializedName

data class TeamDetailsResponse(
    @SerializedName("activeCompetitions")
    val activeCompetitions: List<ActiveCompetition>? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("area")
    val area: AreaX? = null,
    @SerializedName("clubColors")
    val clubColors: String? = null,
    @SerializedName("crestUrl")
    val crestUrl: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("founded")
    val founded: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lastUpdated")
    val lastUpdated: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null,
    @SerializedName("squad")
    val squad: List<Squad>? = null,
    @SerializedName("tla")
    val tla: String? = null,
    @SerializedName("venue")
    val venue: String? = null,
    @SerializedName("website")
    val website: String? = null
)