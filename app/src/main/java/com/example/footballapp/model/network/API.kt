package com.example.footballapp.model.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val url = "https://api.football-data.org/v2/"

    private val myClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: FootballApiService = retrofit.create(FootballApiService::class.java)
}