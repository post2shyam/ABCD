package com.post2shyam.reverbuzzy.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName

data class CountryListRsp(
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String,
    @SerializedName("subregion") val subregion: String
)