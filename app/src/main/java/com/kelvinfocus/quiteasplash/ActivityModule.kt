package com.kelvinfocus.quiteasplash

import com.kelvinfocus.quiteasplash.api.ApiClient
import com.kelvinfocus.quiteasplash.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

//    @Provides
//    @ActivityScoped
//    fun provideApiClient(): ApiClient = ApiClient()

//    @Provides
//    @ActivityScoped
//    fun provideUnsplashService(okHttpClient: OkHttpClient): UnsplashService {
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(UnsplashService.BASE_URL)
//            .client(okHttpClient)
//            .build()
//            .create(UnsplashService::class.java)
//    }

//    @Provides
//    @ActivityScoped
//    fun provideUnsplashRepo(
//        retrofit: Retrofit
//    ) = retrofit.create(UnsplashRetro::class.java)
}