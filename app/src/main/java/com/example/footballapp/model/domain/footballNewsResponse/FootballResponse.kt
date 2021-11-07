package com.example.footballapp.model.domain.footballNewsResponse


import com.google.gson.annotations.SerializedName

data class FootballResponse(
    @SerializedName("articles")
    val articles: List<Article>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("totalResults")
    val totalResults: Int? = null
)