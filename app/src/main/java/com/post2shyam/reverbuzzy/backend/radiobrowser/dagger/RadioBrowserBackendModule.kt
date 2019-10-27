package com.post2shyam.reverbuzzy.backend.radiobrowser.dagger

import com.post2shyam.reverbuzzy.backend.radiobrowser.RADIO_BROWERSER_BASE_URL
import com.post2shyam.reverbuzzy.backend.radiobrowser.RadioBrowserDirectoryServices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RadioBrowserBackendModule {

  @Singleton
  @Provides
  fun providesHTTPInterceptor(): HttpLoggingInterceptor {
    //TODO: Modify logging level for release and debug variants
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    return httpLoggingInterceptor.apply {
      httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
  }

  @Singleton
  @Provides
  fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
  }

  @Singleton
  @Provides
  fun provideRadioBrowserRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(RADIO_BROWERSER_BASE_URL)
        .client(okHttpClient)
        //Read the gson responses
        .addConverterFactory(GsonConverterFactory.create())
        //Invoke via RxJava observables
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @Singleton
  @Provides
  fun providesRadioBrowserDirectoryServices(retrofit: Retrofit): RadioBrowserDirectoryServices {
    return retrofit.create(RadioBrowserDirectoryServices::class.java)
  }
}