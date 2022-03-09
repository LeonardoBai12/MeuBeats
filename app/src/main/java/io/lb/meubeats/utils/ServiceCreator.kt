package io.lb.meubeats.utils

import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*

private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
private val headerInterceptor = Interceptor { chain ->
    var request = chain.request()

    request = request.newBuilder()
        .addHeader("x-device-type", Build.DEVICE)
        .addHeader("Accept-Language", Locale.getDefault().language)
        .build()

    val response = chain.proceed(request)
    response
}

val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
    .addInterceptor(headerInterceptor)
    .addInterceptor(logger)