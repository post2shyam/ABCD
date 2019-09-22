package com.post2shyam.abcd.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserLanguageRsp(
    @SerializedName("stationcount")
    val stationcount: String,

    @SerializedName("value")
    val language: String
)