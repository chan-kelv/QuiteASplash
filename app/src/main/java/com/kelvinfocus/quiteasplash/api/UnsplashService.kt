package com.kelvinfocus.quiteasplash.api

import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {
    @GET("/photos")
    suspend fun getEditorialPhotos(@Query("client_id") clientId: String,
                           @Query("page") page: Int,
                           @Query("per_page") pageSize: Int): Response<List<UnsplashPhoto>>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}