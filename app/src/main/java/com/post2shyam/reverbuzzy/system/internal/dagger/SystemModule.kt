package com.post2shyam.reverbuzzy.system.internal.dagger

import android.app.Application
import com.post2shyam.reverbuzzy.BuildConfig
import com.post2shyam.reverbuzzy.system.localstore.IPersistentStoreManager
import com.post2shyam.reverbuzzy.system.localstore.internal.SharedPreferenceStoreManager
import com.post2shyam.reverbuzzy.system.logger.AnalyticsLogTree
import com.post2shyam.reverbuzzy.system.logger.DebugLogTree
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class SystemModule {
  @Singleton
  @Provides
  fun providePersistentStoreManager(application: Application): IPersistentStoreManager {
    return SharedPreferenceStoreManager(application)
  }

  @Singleton
  @Provides
  fun provideTimberLogTree(): Timber.Tree {
    return if (BuildConfig.DEBUG) {
      DebugLogTree()
    } else {
      AnalyticsLogTree()
    }
  }
  //TODO: Add more systemscope providers here
}