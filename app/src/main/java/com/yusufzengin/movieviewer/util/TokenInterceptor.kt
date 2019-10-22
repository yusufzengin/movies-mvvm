package com.yusufzengin.movieviewer.util

import com.yusufzengin.movieviewer.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (request.header("No-Authentication") == null) {
            val url = request.url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.MOVIEDB_API_KEY)
                .build()
            request = request.newBuilder()
                .url(url)
                .build()
        }
        return chain.proceed(request)
    }
}