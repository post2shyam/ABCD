package com.post2shyam.reverbuzzy.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserLanguageRsp(
  @SerializedName("stationName")
    val stationcount: String,

    @SerializedName("value")
    val language: String
)