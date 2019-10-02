package com.post2shyam.reverbuzzy.internal.dagger

import android.app.Application
import com.post2shyam.reverbuzzy.backend.radiobrowser.dagger.RadioBrowserBackendModule
import com.post2shyam.reverbuzzy.screens.internal.dagger.ActivityModule
import com.post2shyam.reverbuzzy.system.internal.dagger.SystemModule
import com.post2shyam.reverbuzzy.system.mainapplication.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
      SystemModule::class,
      ActivityModule::class,
      RadioBrowserBackendModule::class]
)

interface AppComponent {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance application: Application): AppComponent
  }

  fun inject(mainApplication: MainApplication)
}