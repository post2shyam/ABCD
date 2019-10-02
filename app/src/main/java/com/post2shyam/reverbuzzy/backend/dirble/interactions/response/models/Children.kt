package com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models

import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("ancestry") val ancestry: String,
    @SerializedName("children") val children: List<Any>,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("description") val description: String,
    @SerializedName("id") val id: Int,
    @SerializedName("position") val position: Any,
    @SerializedName("slug") val slug: String,
    @SerializedName("title") val title: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("urlid") val urlid: Any
)
