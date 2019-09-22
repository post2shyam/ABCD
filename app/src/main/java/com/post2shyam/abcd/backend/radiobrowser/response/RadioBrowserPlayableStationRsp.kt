package com.post2shyam.abcd.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserPlayableStationRsp(
    @SerializedName("id")
    val stationId: String,

    @SerializedName("message")
    val message: String,

    @SerializedName("name")
    val stationName: String,

    @SerializedName("ok")
    val ok: String,

    @SerializedName("url")
    val stationUrl: String
)