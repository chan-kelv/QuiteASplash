package com.kelvinfocus.quiteasplash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelvinfocus.quiteasplash.api.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
): ViewModel() {
    private val _fetchImageAction: MutableLiveData<Boolean> = MutableLiveData(false)
    val fetchImageAction: LiveData<Boolean> = _fetchImageAction

    fun fetchImage() {
//        _fetchImageAction.value = true
//        _fetchImageAction.value = false

        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                unsplashRepository.getImages()
            }

            if (data.isSuccessful) {
                Timber.d("image1: ${data.body()?.first()?.id ?: "no photo"}")
            } else {
                Timber.e(data.errorBody().toString())
            }
        }
    }
}