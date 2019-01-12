package com.post2shyam.abcd.system.mainapplication

import android.app.Activity
import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.post2shyam.abcd.internal.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector {

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  @Inject
  lateinit var timberTree: Timber.Tree

  // this is required to setup Dagger2 for Activity
  override fun activityInjector(): AndroidInjector<Activity> = activityInjector

  override fun onCreate() {
    super.onCreate()
    initDagger()
    initLogger()
    initAppCenter()
  }

  private fun initLogger() {
    Timber.plant(timberTree)
  }

  private fun initDagger() {
    DaggerAppComponent.builder()
        .application(this)
        .build()
        .inject(this)
  }

  private fun initAppCenter() {
    AppCenter.start(
        this, "17503c5b-6185-40b3-b506-135c094c5158", Analytics::class.java, Crashes::class.java
    )
  }
}