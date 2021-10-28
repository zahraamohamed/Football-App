package com.example.footballapp.model.network

import com.example.footballapp.util.Constant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val client = OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: FootballApiService = retrofit.create(FootballApiService::class.java)

}