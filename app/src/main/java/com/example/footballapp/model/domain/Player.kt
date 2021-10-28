package com.example.footballapp.model.domain


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("countryOfBirth")
    var countryOfBirth: String? = "",
    @SerializedName("dateOfBirth")
    var dateOfBirth: String? = "",
    @SerializedName("firstName")
    var firstName: String? = "",
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("lastName")
    var lastName: String? = "",
    @SerializedName("lastUpdated")
    var lastUpdated: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("nationality")
    var nationality: String? = "",
    @SerializedName("position")
    var position: String? = "",
    @SerializedName("shirtNumber")
    var shirtNumber: Any? = Any()
)