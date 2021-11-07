package com.example.footballapp.model.network

import com.example.footballapp.util.Constant
import okhttp3.Interceptor
import okhttp3.Response

class NewsInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("apiKey",Constant.NEWS_API_KEY)
            .build()
    return chain.proceed(request)
    }
}