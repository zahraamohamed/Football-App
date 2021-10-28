package com.example.footballapp.model.network

import okhttp3.Interceptor
import okhttp3.Response

class FootballInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
            .newBuilder()
            .addHeader("X-Auth-Token","5473cb5eec804dd088f823dbfead5eeb")
            .build()
        return chain.proceed(request)
    }
}