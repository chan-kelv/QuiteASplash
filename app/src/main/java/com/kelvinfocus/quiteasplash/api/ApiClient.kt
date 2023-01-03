package com.kelvinfocus.quiteasplash.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiClient @Inject constructor() {
    val retrofitClient: Retrofit by lazy {
        retrofitClientBuilder(UnsplashService.BASE_URL)
    }

    private fun retrofitClientBuilder(baseUrlEndpoint: String): Retrofit {
        val loggingIntercept = HttpLoggingInterceptor()
        loggingIntercept.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingIntercept)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrlEndpoint)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}