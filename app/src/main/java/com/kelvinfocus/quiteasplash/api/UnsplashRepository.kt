package com.kelvinfocus.quiteasplash.api

import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import retrofit2.Response
import javax.inject.Inject

class UnsplashRepository @Inject constructor(
    private val unsplashService: UnsplashService
) {
//    private val unsplashRepo: UnsplashService by lazy {
//        retrofit.retrofitClient.create(UnsplashService::class.java)
//    }

    suspend fun getImages(): Response<List<UnsplashPhoto>> {
        return unsplashService.getEditorialPhotos(UnsplashPhotoPicker.getAccessKey(), 1, 20)
    }
}