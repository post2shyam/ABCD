package com.post2shyam.abcd.screens.main.internal.dagger

import com.post2shyam.abcd.screens.main.internal.MoodAdapter
import dagger.Module
import dagger.Provides

@Module
class MoodModule {
  @Provides
  fun providesMoodAdapter(): MoodAdapter = MoodAdapter()
}