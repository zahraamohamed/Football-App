package com.example.footballapp.model.network.news

import com.example.footballapp.util.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApi {
    private val client = OkHttpClient
        .Builder()
        .addInterceptor(NewsInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.NEWS_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newsService: INewsApiService = retrofit.create(INewsApiService::class.java)
}