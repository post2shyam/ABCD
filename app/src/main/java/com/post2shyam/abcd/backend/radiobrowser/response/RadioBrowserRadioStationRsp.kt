package com.post2shyam.abcd.backend.radiobrowser.response

import com.google.gson.annotations.SerializedName


data class RadioBrowserRadioStationRsp(
    @SerializedName("bitrate")
    val bitrate: String,

    @SerializedName("changeuuid")
    val changeuuid: String,

    @SerializedName("clickcount")
    val clickcount: String,

    @SerializedName("clicktimestamp")
    val clicktimestamp: String,

    @SerializedName("clicktrend")
    val clicktrend: String,

    @SerializedName("codec")
    val codec: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("countrycode")
    val countrycode: String,

    @SerializedName("favicon")
    val favicon: String,

    @SerializedName("hls")
    val hls: String,

    @SerializedName("homepage")
    val homepage: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("ip")
    val ip: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("lastchangetime")
    val lastchangetime: String,

    @SerializedName("lastcheckok")
    val lastcheckok: String,

    @SerializedName("lastcheckoktime")
    val lastcheckoktime: String,

    @SerializedName("lastchecktime")
    val lastchecktime: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("negativevotes")
    val negativevotes: String,

    @SerializedName("state")
    val state: String,

    @SerializedName("stationuuid")
    val stationuuid: String,

    @SerializedName("tags")
    val tags: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("votes")
    val votes: String
)