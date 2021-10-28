package com.example.footballapp.model.domain.competitionsResponse


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("countryCode")
    val countryCode: String? = null,
    @SerializedName("ensignUrl")
    val ensignUrl: Any? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)