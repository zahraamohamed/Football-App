package com.example.footballapp.model.domain.teamDetailsResponse


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)