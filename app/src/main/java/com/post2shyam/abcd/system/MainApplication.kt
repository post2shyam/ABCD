package com.post2shyam.abcd.system

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCenter.start(
            this, "17503c5b-6185-40b3-b506-135c094c5158", Analytics::class.java, Crashes::class.java
        )
    }
}