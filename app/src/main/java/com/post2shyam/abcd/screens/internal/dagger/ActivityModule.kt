package com.post2shyam.abcd.screens.internal.dagger

import com.post2shyam.abcd.screens.mood.MoodListActivity
import com.post2shyam.abcd.screens.mood.internal.dagger.MoodModule
import com.post2shyam.abcd.screens.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector(modules = [MoodModule::class])
  internal abstract fun contributeMoodListActivity(): MoodListActivity

  @ContributesAndroidInjector
  internal abstract fun contributeSplashActivity(): SplashActivity
  // Add bindings for other sub-components here
}