package com.post2shyam.abcd.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName

data class ContinentListRsp(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String
)