package com.post2shyam.reverbuzzy.screens.internal.dagger

import com.post2shyam.reverbuzzy.screens.mood.MoodListActivity
import com.post2shyam.reverbuzzy.screens.mood.internal.dagger.MoodModule
import com.post2shyam.reverbuzzy.screens.splash.SplashActivity
import com.post2shyam.reverbuzzy.screens.stationlist.StationListActivity
import com.post2shyam.reverbuzzy.screens.stationlist.internal.dagger.StationListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector(modules = [StationListModule::class])
  internal abstract fun contributeStationListActivity(): StationListActivity

  @ContributesAndroidInjector(modules = [MoodModule::class])
  internal abstract fun contributeMoodListActivity(): MoodListActivity

  @ContributesAndroidInjector
  internal abstract fun contributeSplashActivity(): SplashActivity
  // Add bindings for other sub-components here
}