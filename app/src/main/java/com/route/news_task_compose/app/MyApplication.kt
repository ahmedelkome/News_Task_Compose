package com.route.news_task_compose.app

import android.app.Application
import com.route.data.utils.ConnectivityChecker
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ConnectivityChecker.context = this
    }
}