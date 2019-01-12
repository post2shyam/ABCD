package com.post2shyam.abcd.backend.dirble.interactions.response

import com.google.gson.annotations.SerializedName
import com.post2shyam.abcd.backend.dirble.interactions.response.models.Categories
import com.post2shyam.abcd.backend.dirble.interactions.response.models.Image
import com.post2shyam.abcd.backend.dirble.interactions.response.models.Streams

data class PopularStationsRsp(
  @SerializedName("id") val id: Int,
  @SerializedName("name") val name: String,
  @SerializedName("country") val country: String,
  @SerializedName("image") val image: Image,
  @SerializedName("slug") val slug: String,
  @SerializedName("website") val website: String,
  @SerializedName("twitter") val twitter: String,
  @SerializedName("facebook") val facebook: String,
  @SerializedName("total_listeners") val total_listeners: Int,
  @SerializedName("categories") val categories: List<Categories>,
  @SerializedName("streams") val streams: List<Streams>,
  @SerializedName("created_at") val created_at: String,
  @SerializedName("updated_at") val updated_at: String
)