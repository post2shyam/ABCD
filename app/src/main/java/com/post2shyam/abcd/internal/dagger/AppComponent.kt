package com.post2shyam.abcd.internal.dagger

import android.app.Application
import com.post2shyam.abcd.screens.internal.dagger.ActivityModule
import com.post2shyam.abcd.system.internal.dagger.SystemModule
import com.post2shyam.abcd.system.mainapplication.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, SystemModule::class, ActivityModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainApplication: MainApplication)
}