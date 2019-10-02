package com.post2shyam.reverbuzzy.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models.Image

data class SimilarStationsToIdRsp(
    @SerializedName("country") val country: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("description") val description: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: Image,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("total_listeners") val totalListeners: Int,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("website") val website: String
)