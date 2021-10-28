package com.example.footballapp.model.domain.specificCompetitionMatchesResponse


import com.google.gson.annotations.SerializedName

data class Winner(
    @SerializedName("crestUrl")
    val crestUrl: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null,
    @SerializedName("tla")
    val tla: String? = null
)