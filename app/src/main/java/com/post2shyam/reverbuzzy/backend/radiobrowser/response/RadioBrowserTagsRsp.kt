package com.post2shyam.reverbuzzy.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserTagsRsp(
    @SerializedName("stationcount")
    val stationCount: Int,

    @SerializedName("value")
    val mood: String
)