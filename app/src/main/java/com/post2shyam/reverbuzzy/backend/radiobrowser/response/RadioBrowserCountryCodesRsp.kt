package com.post2shyam.reverbuzzy.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserCountryCodesRsp(
  @SerializedName("stationName")
    val stationCount: String,

    @SerializedName("value")
    val countryCode: String
)