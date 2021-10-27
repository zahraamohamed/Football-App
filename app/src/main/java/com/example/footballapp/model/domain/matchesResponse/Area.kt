package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("ensignUrl")
    val ensignUrl: String? = null,
    @SerializedName("name")
    val name: String? = null
)