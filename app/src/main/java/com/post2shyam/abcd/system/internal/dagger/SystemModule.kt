package com.post2shyam.abcd.system.internal.dagger

import com.post2shyam.abcd.system.localstore.IPersistentStoreManager
import com.post2shyam.abcd.system.localstore.internal.SharedPreferenceStoreManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SystemModule {
    @Singleton
    @Provides
    fun providePersistentStoreManager(): IPersistentStoreManager {
        return SharedPreferenceStoreManager()
    }
    //TODO: Add more systemscope providers here
}