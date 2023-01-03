package com.kelvinfocus.quiteasplash

import android.app.Application
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class QuiteASplashApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Timber init
        Timber.plant(Timber.DebugTree())

        UnsplashPhotoPicker.init(
            this, // application
            BuildConfig.unsplashapiKey,
            BuildConfig.unsplashapiSecret
            /* optional page size */
        )
    }
}