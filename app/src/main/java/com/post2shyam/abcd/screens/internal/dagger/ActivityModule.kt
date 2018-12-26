package com.post2shyam.abcd.screens.internal.dagger

import com.post2shyam.abcd.screens.first.FirstActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeFirstActivity(): FirstActivity

    // Add bindings for other sub-components here
}