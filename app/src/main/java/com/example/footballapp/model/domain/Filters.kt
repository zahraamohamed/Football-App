package com.example.footballapp.model.domain


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("limit")
    var limit: Int? = 0
)