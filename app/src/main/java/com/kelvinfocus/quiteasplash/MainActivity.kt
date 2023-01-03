package com.kelvinfocus.quiteasplash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kelvinfocus.quiteasplash.ui.theme.QuiteASplashTheme
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val vm: SplashViewModel by viewModels()

    companion object {
        final val IMAGE_CODE = 12345
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuiteASplashTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        GetImagesButton() {
                            fetchImages()
                        }
                    }
                }
            }
        }

        vm.fetchImageAction.observe(this) { shouldFetch ->
            if (shouldFetch) {
                startActivityForResult(UnsplashPickerActivity.getStartingIntent(this, false), IMAGE_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_CODE) {
            val photos = data?.getParcelableArrayExtra(UnsplashPickerActivity.EXTRA_PHOTOS)
            Timber.d("photos: ${photos?.first()}")
        }
    }

    fun fetchImages() {
        vm.fetchImage()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GetImagesButton(click: () -> Unit) {
    val context = LocalContext.current
    Button(
        onClick = click,
        modifier = Modifier
            .padding(vertical = 5.dp)
    ) {
        Text(text = "Get My Images")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuiteASplashTheme {
        Column {
            GetImagesButton({})
        }
    }
}