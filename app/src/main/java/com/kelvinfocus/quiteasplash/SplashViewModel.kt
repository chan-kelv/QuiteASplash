package com.kelvinfocus.quiteasplash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {
    private val _fetchImageAction: MutableLiveData<Boolean> = MutableLiveData(false)
    val fetchImageAction: LiveData<Boolean> = _fetchImageAction

    fun fetchImage() {
        _fetchImageAction.value = true
        _fetchImageAction.value = false
    }
}