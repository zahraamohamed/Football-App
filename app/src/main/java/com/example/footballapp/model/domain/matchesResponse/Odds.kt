package com.example.footballapp.model.domain.matchesResponse


import com.google.gson.annotations.SerializedName

data class Odds(
    @SerializedName("msg")
    val msg: String? = null
)