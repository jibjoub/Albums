package com.example.albums
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AlbumsApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
