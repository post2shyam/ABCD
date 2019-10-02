package com.post2shyam.reverbuzzy.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models.Children

data class AllSongCategoriesAsTreeRsp(
    @SerializedName("ancestry")
    val ancestry: Any,
    @SerializedName("children")
    val children: List<Children>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("position")
    val position: Any,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urlid")
    val urlid: Any
)
