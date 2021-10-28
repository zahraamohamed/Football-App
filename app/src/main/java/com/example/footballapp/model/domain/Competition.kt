package com.example.footballapp.model.domain


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("area")
    var area: Area? = Area(),
    @SerializedName("code")
    var code: String? = "",
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("lastUpdated")
    var lastUpdated: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("plan")
    var plan: String? = ""
)