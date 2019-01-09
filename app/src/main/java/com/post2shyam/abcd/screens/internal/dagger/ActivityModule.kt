package com.post2shyam.abcd.screens.internal.dagger

import com.post2shyam.abcd.screens.first.NetworkActivity
import com.post2shyam.abcd.screens.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeFirstActivity(): NetworkActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity
    // Add bindings for other sub-components here
}