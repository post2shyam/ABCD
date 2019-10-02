package com.post2shyam.reverbuzzy.backend.dirble.internal

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class DirbleRequestInterceptor(private val token: String) : Interceptor {
  override fun intercept(chain: Chain): Response {
    val request = chain.request()

    val url = request.url()
      .newBuilder()
      .addQueryParameter("token", token)
      .build()

    val newRequest = request.newBuilder()
      .url(url)
      .build()

    return chain.proceed(newRequest)
  }
}