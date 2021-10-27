package com.example.footballapp.model.domain.teamRankResponse


import com.google.gson.annotations.SerializedName

data class Standing(
    @SerializedName("group")
    val group: Any? = null,
    @SerializedName("stage")
    val stage: String? = null,
    @SerializedName("table")
    val table: List<Table>? = null,
    @SerializedName("type")
    val type: String? = null
)