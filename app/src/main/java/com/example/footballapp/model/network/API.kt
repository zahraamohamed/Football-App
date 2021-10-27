package com.example.footballapp.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.football-data.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: FootballApiService = retrofit.create(FootballApiService::class.java)
}