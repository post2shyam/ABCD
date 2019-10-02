package com.post2shyam.reverbuzzy.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName

data class WorldWideRecentPlayedSongsRsp(
    @SerializedName("date") val date: String,
    @SerializedName("id") val id: String,
    @SerializedName("info") val info: Any,
    @SerializedName("name") val name: String,
    @SerializedName("station_id") val stationId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("week") val week: Int,
    @SerializedName("year") val year: Int
)
