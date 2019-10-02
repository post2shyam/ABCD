package com.post2shyam.reverbuzzy.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models.Category
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models.Image
import com.post2shyam.reverbuzzy.backend.dirble.interactions.response.models.Streams

data class NewStationsRsp(
  @SerializedName("categories") val categories: List<Category>,
  @SerializedName("country") val country: String,
  @SerializedName("created_at") val createdAt: String,
  @SerializedName("facebook") val facebook: String,
  @SerializedName("id") val id: Int,
  @SerializedName("image") val image: Image,
  @SerializedName("name") val name: String,
  @SerializedName("slug") val slug: String,
  @SerializedName("streams") val streams: List<Streams>,
  @SerializedName("total_listeners") val totalListeners: Int,
  @SerializedName("twitter") val twitter: String,
  @SerializedName("updated_at") val updatedAt: String,
  @SerializedName("website") val website: String
)