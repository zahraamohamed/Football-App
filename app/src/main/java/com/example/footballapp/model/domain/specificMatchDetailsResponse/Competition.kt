package com.example.footballapp.model.domain.specificMatchDetailsResponse


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("area")
    val area: Area? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)