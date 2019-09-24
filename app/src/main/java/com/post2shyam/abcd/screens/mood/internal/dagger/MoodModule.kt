package com.post2shyam.abcd.screens.mood.internal.dagger

import com.post2shyam.abcd.screens.mood.internal.MoodAdapter
import dagger.Module
import dagger.Provides

@Module
class MoodModule {
  @Provides
  fun providesMoodAdapter(): MoodAdapter = MoodAdapter()
}