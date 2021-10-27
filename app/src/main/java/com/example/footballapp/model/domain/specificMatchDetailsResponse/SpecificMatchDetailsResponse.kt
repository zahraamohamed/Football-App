package com.example.footballapp.model.domain.specificMatchDetailsResponse


import com.google.gson.annotations.SerializedName

data class SpecificMatchDetailsResponse(
    @SerializedName("head2head")
    val head2head: Head2head? = null,
    @SerializedName("match")
    val match: Match? = null
)