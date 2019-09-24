package com.post2shyam.abcd.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserCountryCodesRsp(
    @SerializedName("stationCount")
    val stationCount: String,

    @SerializedName("value")
    val countryCode: String
)