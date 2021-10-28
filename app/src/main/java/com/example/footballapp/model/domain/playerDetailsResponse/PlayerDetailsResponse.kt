package com.example.footballapp.model.domain.playerDetailsResponse


import com.google.gson.annotations.SerializedName

data class PlayerDetailsResponse(
    @SerializedName("countryOfBirth")
    val countryOfBirth: String? = null,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("lastUpdated")
    val lastUpdated: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nationality")
    val nationality: String? = null,
    @SerializedName("position")
    val position: String? = null,
    @SerializedName("shirtNumber")
    val shirtNumber: Any? = null
)