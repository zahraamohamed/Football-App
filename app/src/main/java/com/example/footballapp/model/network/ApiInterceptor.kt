package com.example.footballapp.model.network

import com.example.footballapp.util.Constant
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Auth-Token", Constant.API_TOKEN)
            .build()
        return chain.proceed(request)
    }
}