package com.example.footballapp.model.network

import com.example.footballapp.util.Constant.url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(ApiInterceptor())
        addInterceptor(HttpLoggingInterceptor())
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: FootballApiService = retrofit.create(FootballApiService::class.java)
}