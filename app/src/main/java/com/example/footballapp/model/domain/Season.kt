package com.example.footballapp.model.domain


import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("currentMatchday")
    var currentMatchday: Int? = 0,
    @SerializedName("endDate")
    var endDate: String? = "",
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("startDate")
    var startDate: String? = "",
    @SerializedName("winner")
    var winner: Any? = Any()
)