package com.post2shyam.reverbuzzy.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserStatesRsp(
    @SerializedName("country")
    val country: String,

  @SerializedName("stationName")
    val stationcount: String,

    @SerializedName("value")
    val stateName: String
)