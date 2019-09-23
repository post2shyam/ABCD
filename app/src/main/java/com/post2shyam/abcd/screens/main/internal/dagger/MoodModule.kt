package com.post2shyam.abcd.screens.main.internal.dagger

import com.post2shyam.abcd.screens.main.internal.MoodAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoodModule {
  @Singleton
  @Provides
  fun providesMoodAdapter(): MoodAdapter = MoodAdapter()
}