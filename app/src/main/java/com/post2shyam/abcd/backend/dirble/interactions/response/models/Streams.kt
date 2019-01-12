package com.post2shyam.abcd.backend.dirble.interactions.response.models

import com.google.gson.annotations.SerializedName

data class Streams(

  @SerializedName("stream") val stream: String,
  @SerializedName("bitrate") val bitrate: Int,
  @SerializedName("content_type") val content_type: String,
  @SerializedName("listeners") val listeners: Int,
  @SerializedName("status") val status: Int
)