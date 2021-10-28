package com.example.footballapp.model.domain.specificMatchDetailsResponse


import com.google.gson.annotations.SerializedName

data class HomeTeamX(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)