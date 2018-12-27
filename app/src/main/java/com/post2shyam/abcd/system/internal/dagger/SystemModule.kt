package com.post2shyam.abcd.system.internal.dagger

import android.app.Application
import com.post2shyam.abcd.BuildConfig
import com.post2shyam.abcd.system.localstore.IPersistentStoreManager
import com.post2shyam.abcd.system.localstore.internal.SharedPreferenceStoreManager
import com.post2shyam.abcd.system.logger.DebugLogTree
import com.post2shyam.abcd.system.logger.ReleaseLogTree
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
            ReleaseLogTree()
        }
    }
    //TODO: Add more systemscope providers here
}