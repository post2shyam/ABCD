package com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models

import com.google.gson.annotations.SerializedName

data class Image(
  @SerializedName("url") val url: String,
  @SerializedName("thumb") val thumb: Thumb
)