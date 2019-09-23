package com.post2shyam.abcd.screens.internal.dagger

import com.post2shyam.abcd.screens.main.MainScreen
import com.post2shyam.abcd.screens.splash.Splash
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
  @ContributesAndroidInjector
  internal abstract fun contributeFirstActivity(): MainScreen

  @ContributesAndroidInjector
  internal abstract fun contributeSplashActivity(): Splash
  // Add bindings for other sub-components here
}