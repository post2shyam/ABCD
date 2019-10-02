package com.post2shyam.reverbuzzy.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserVoteRsp(
    @SerializedName("message")
    val message: String,

    @SerializedName("ok")
    val ok: String
)