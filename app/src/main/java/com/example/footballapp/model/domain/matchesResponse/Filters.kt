package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("dateFrom")
    val dateFrom: String? = null,
    @SerializedName("dateTo")
    val dateTo: String? = null,
    @SerializedName("permission")
    val permission: String? = null
)