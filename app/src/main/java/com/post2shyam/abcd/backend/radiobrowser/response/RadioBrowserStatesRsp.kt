package com.post2shyam.abcd.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserStatesRsp(
    @SerializedName("country")
    val country: String,

    @SerializedName("stationCount")
    val stationcount: String,

    @SerializedName("value")
    val stateName: String
)