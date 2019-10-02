package com.post2shyam.reverbuzzy.backend.dirble.internal.dagger

import com.post2shyam.reverbuzzy.backend.dirble.internal.DIRBLE_BASE_URL
import com.post2shyam.reverbuzzy.backend.dirble.internal.DirbleRadioDirectoryServices
import com.post2shyam.reverbuzzy.backend.dirble.internal.DirbleRequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DirbleBackendModule {

  @Singleton
  @Provides
  fun providesInterceptor(): Interceptor {
    return DirbleRequestInterceptor("c3837c10982d58876d04e71696")
  }

  @Singleton
  @Provides
  fun providesHTTPInterceptor(): HttpLoggingInterceptor {
    //TODO: Modify logging level for release and debug variants
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
  }

  @Singleton
  @Provides
  fun provideOkHttpClient(
    interceptor: Interceptor,
    loggingInterceptor: HttpLoggingInterceptor
  ): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(loggingInterceptor)
        .build()
  }

  @Singleton
  @Provides
  fun provideDirbleRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(DIRBLE_BASE_URL)
        .client(okHttpClient)
        //Read the gson responses
        .addConverterFactory(GsonConverterFactory.create())
        //Invoke via RxJava observables
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @Singleton
  @Provides
  fun providesDirbleBackendServices(retrofit: Retrofit): DirbleRadioDirectoryServices {
    return retrofit.create(DirbleRadioDirectoryServices::class.java)
  }
}