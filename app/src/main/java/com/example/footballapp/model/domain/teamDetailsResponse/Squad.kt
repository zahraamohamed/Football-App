package com.example.footballapp.model.domain.teamDetailsResponse


import com.google.gson.annotations.SerializedName

data class Squad(
    @SerializedName("countryOfBirth")
    val countryOfBirth: String? = null,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nationality")
    val nationality: String? = null,
    @SerializedName("position")
    val position: String? = null,
    @SerializedName("role")
    val role: String? = null,
    @SerializedName("shirtNumber")
    val shirtNumber: Any? = null
)