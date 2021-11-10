package com.example.footballapp.model.network.news

import com.example.footballapp.model.domain.footballNewsResponse.FootballResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface INewsApiService {
    @GET("top-headlines")
    suspend fun getFootballNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ):Response<FootballResponse>
}