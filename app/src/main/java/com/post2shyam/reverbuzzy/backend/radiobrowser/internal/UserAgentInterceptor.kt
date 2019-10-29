package com.post2shyam.reverbuzzy.backend.radiobrowser.internal

import android.app.Application
import com.post2shyam.reverbuzzy.BuildConfig
import com.post2shyam.reverbuzzy.R
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class UserAgentInterceptor(val application: Application) : Interceptor {
  override fun intercept(chain: Chain): Response {
    val newRequest = chain.request()
        .newBuilder()
        .header(
            "User-Agent", application.getString(R.string.app_name) + '/' + BuildConfig.VERSION_NAME
        )
        .build()
    return chain.proceed(newRequest)
  }
}